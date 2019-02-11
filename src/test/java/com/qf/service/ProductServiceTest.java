package com.qf.service;

import com.qf.BaseTest;
import com.qf.dto.ImageHolder;
import com.qf.dto.ProductExecution;
import com.qf.dto.ShopExecution;
import com.qf.enums.ProductStateEnum;
import com.qf.pojo.po.Product;
import com.qf.pojo.po.ProductCategory;
import com.qf.pojo.po.Shop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() throws FileNotFoundException {
        Product product = new Product();
        Shop shop = new Shop();
        ProductCategory productCategory = new ProductCategory();
        shop.setShopId(1L);
        productCategory.setProductCategoryId(16L);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("测试商品1");
        product.setProductDesc("他是测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        //创建缩略图文件流
        File thumbnailFile = new File("/Users/cxx/Downloads/img/1.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder imageHolder = new ImageHolder(thumbnailFile.getName(),is);
        //另建两个文件添加到详情图列表
        File thumbnailFile1 = new File("/Users/cxx/Downloads/img/1.jpg");
        InputStream is1 = new FileInputStream(thumbnailFile1);
        File thumbnailFile2 = new File("/Users/cxx/Downloads/img/3.jpg");
        InputStream is2 = new FileInputStream(thumbnailFile2);
        List<ImageHolder> productImgList = new ArrayList<>();
        productImgList.add(new ImageHolder(thumbnailFile1.getName(),is1));
        productImgList.add(new ImageHolder(thumbnailFile2.getName(),is2));
        //添加商品验证
        ProductExecution pe = productService.addProduct(product,imageHolder,productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());

    }

    @Test
    public void testModifyProduct() throws FileNotFoundException {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(16L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductName("正式的商品");
        product.setProductDesc("正式的商品");
        //创建缩略图文件流
        File thumbnailFile = new File("/Users/cxx/Downloads/img/2.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder imageHolder = new ImageHolder(thumbnailFile.getName(),is);
        //另建两个文件添加到详情图列表
        File thumbnailFile1 = new File("/Users/cxx/Downloads/img/1.jpg");
        InputStream is1 = new FileInputStream(thumbnailFile1);
        File thumbnailFile2 = new File("/Users/cxx/Downloads/img/3.jpg");
        InputStream is2 = new FileInputStream(thumbnailFile2);
        List<ImageHolder> productImgList = new ArrayList<>();
        productImgList.add(new ImageHolder(thumbnailFile1.getName(),is1));
        productImgList.add(new ImageHolder(thumbnailFile2.getName(),is2));
        //添加商品并验证
        ProductExecution pe = productService.modifyProduct(product,imageHolder,productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
    }
}
