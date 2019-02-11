package com.qf.web.shopadmin;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.dto.ImageHolder;
import com.qf.dto.ProductExecution;
import com.qf.enums.ProductStateEnum;
import com.qf.exceptions.ProductOperationException;
import com.qf.pojo.po.Product;
import com.qf.pojo.po.ProductCategory;
import com.qf.pojo.po.Shop;
import com.qf.service.ProductCategoryService;
import com.qf.service.ProductService;
import com.qf.util.CodeUtil;
import com.qf.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ProductManagementController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    private static final int IMAGEMAXCOUNT = 6;
    @PostMapping("/addproduct")
    @ResponseBody
    private Map<String,Object> addProduct(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        //验证码验证
        if(!CodeUtil.checkVerifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errMSg","输入了错误的验证码");
            return modelMap;
        }
        //接收前端参数的变量的初始化
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        ImageHolder thumbnail = null;
        List<ImageHolder> productImgList = new ArrayList<>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //诺请求中存在文件流，则取出相关的文件
        try {
            if(multipartResolver.isMultipart(request)){
                thumbnail = handleImage((MultipartHttpServletRequest) request, productImgList);
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg","上传的图片不能为空");
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
            return modelMap;
        }
        //尝试获取前端传过来的表单String流并将其转换成Product实体类
        try {
            String productStr = HttpServletRequestUtil.getString(request, "productStr");
            product = mapper.readValue(productStr,Product.class);
        } catch (Exception e) {
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
            return modelMap;
        }
        if (product!=null && thumbnail != null && productImgList.size()> 0 ){
            try {
                //从Session中获取当前店铺的Id赋值给product，减少对前端数据的依赖
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                Shop shop = new Shop();
                shop.setShopId(currentShop.getShopId());
                product.setShop(shop);
                //执行添加操作
                ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
                if(pe.getState() == ProductStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",pe.getStateInfo());
                }
            } catch (ProductOperationException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.toString());
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入商品信息");
        }
        return modelMap;


    }

    private ImageHolder handleImage(MultipartHttpServletRequest request, List<ImageHolder> productImgList) throws IOException {
        ImageHolder thumbnail;
        MultipartHttpServletRequest multipartRequest = request;
        //取出缩略图并构建ImageHolder对象
        CommonsMultipartFile thumbnailFile = (CommonsMultipartFile) multipartRequest.getFile("thumbnail");
        thumbnail = new ImageHolder(thumbnailFile.getOriginalFilename(), thumbnailFile.getInputStream());
        //取出详情图列表构建List<ImageHolder>列表对象，最多支持六张
        for (int i = 0; i < IMAGEMAXCOUNT; i++) {
            CommonsMultipartFile productImgFile = (CommonsMultipartFile) multipartRequest.getFile("productImg" + i);
            if (productImgFile != null) {
                //诺取出的第i哥详情图片文件流不为空，则将其加入详情图列表
                ImageHolder productImg = new ImageHolder(productImgFile.getOriginalFilename(), productImgFile.getInputStream());
                productImgList.add(productImg);
            } else {
                break;
            }
        }
        return thumbnail;
    }

    @GetMapping("/getproductbyid")
    @ResponseBody
    private Map<String,Object> getProductById(@RequestParam Long productId){
        Map<String,Object> modelMap = new HashMap<>();
        //非空判断
        if(productId >-1){
            //获取商品信息
            Product product = productService.getProductById(productId);
            //获取该店铺下的商品类别列表
            List<ProductCategory> productCateList = productCategoryService.getProductCateList(product.getShop().getShopId());
            modelMap.put("product",product);
            modelMap.put("productCategoryList",productCateList);
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","empty productId");
        }
        return modelMap;
    }

    @PostMapping("/modifyproduct")
    @ResponseBody
    private Map<String,Object> modifyProduct(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        //商品编辑时候调用上下架操作的时候调用
        //诺为前者则进行验证码判断，后者跳过
        boolean statusChange = HttpServletRequestUtil.getBoolean(request,"statusChange");
        //验证码验证
        if(!statusChange && !CodeUtil.checkVerifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errMSg","输入了错误的验证码");
            return modelMap;
        }
        //接收前端参数的变量的初始化
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        ImageHolder thumbnail = null;
        List<ImageHolder> productImgList = new ArrayList<>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //诺请求中存在文件流，则取出相关的文件
        try {
            if(multipartResolver.isMultipart(request)){
                thumbnail = handleImage((MultipartHttpServletRequest) request, productImgList);
            }
        } catch (Exception e) {
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
            return modelMap;
        }
        //尝试获取前端传过来的表单String流并将其转换成Product实体类
        try {
            String productStr = HttpServletRequestUtil.getString(request, "productStr");
            product = mapper.readValue(productStr,Product.class);
        } catch (Exception e) {
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
            return modelMap;
        }
        if (product!=null){
            try {
                //从Session中获取当前店铺的Id赋值给product，减少对前端数据的依赖
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                product.setShop(currentShop);
                //执行添加操作
                ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
                if(pe.getState() == ProductStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",pe.getStateInfo());
                }
            } catch (ProductOperationException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.toString());
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入商品信息");
        }
        return modelMap;

    }

    @GetMapping("/getproductlistbyshop")
    @ResponseBody
    private Map<String,Object> getProductListByShop(HttpServletRequest request){
        Map<String,Object> modeMap = new HashMap<>();
        //获取从前台传过来的页码
        int pageIndex = HttpServletRequestUtil.getInt(request,"pageIndex");
        //获取前台传过来的每页商品数
        int pageSize = HttpServletRequestUtil.getInt(request,"pageSize");
        //从当前session中获取店铺信息，获取shopId
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        //空值判断
        if((pageIndex>-1)&&(pageSize>-1)&&(currentShop!=null)&&(currentShop.getShopId()!=null)){
            //获取查询条件进行排列组合
            long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
            String productName = HttpServletRequestUtil.getString(request, "productName");
            Product productCondition = compactProductCondition(currentShop.getShopId(),productCategoryId,productName);
            ProductExecution pe = productService.getProductList(productCondition,pageIndex,pageSize);
            modeMap.put("productList",pe.getProductList());
            modeMap.put("count",pe.getCount());
            modeMap.put("success",true);
        }else {
            modeMap.put("success",false);
            modeMap.put("errMsg","empty pageSize or pageIndex or shopId");
        }
        return modeMap;
    }

    private Product compactProductCondition(Long shopId, long productCategoryId, String productName) {
        Product productCondition = new Product();
        Shop shop = new Shop();
        shop.setShopId(shopId);
        productCondition.setShop(shop);
        //诺有指定类别的要求则添加进去
        if(productCategoryId !=-1L){
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(productCategoryId);
            productCondition.setProductCategory(productCategory);
        }
        //诺有商品名模糊查询的要求则添加进去
        if(productName != null){
            productCondition.setProductName(productName);
        }
        return productCondition;

    }


}