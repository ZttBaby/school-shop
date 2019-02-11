package com.qf.dao;

import com.qf.BaseTest;
import com.qf.pojo.po.Product;
import com.qf.pojo.po.ProductCategory;
import com.qf.pojo.po.ProductImg;
import com.qf.pojo.po.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testAInsertProduct(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(16L);
        Product product1 = new Product();
        product1.setProductName("test1");
        product1.setProductDesc("测试desc1");
        product1.setImgAddr("test1");
        product1.setEnableStatus(1);
        product1.setPriority(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop);
        product1.setProductCategory(pc);
        Product product2 = new Product();
        product2.setProductName("test2");
        product2.setProductDesc("测试desc2");
        product2.setImgAddr("test2");
        product2.setEnableStatus(0);
        product2.setPriority(2);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop);
        product2.setProductCategory(pc);
        Product product3 = new Product();
        product3.setProductName("test3");
        product3.setProductDesc("测试desc3");
        product3.setImgAddr("test3");
        product3.setEnableStatus(1);
        product3.setPriority(3);
        product3.setCreateTime(new Date());
        product3.setLastEditTime(new Date());
        product3.setShop(shop);
        product3.setProductCategory(pc);
        int effectedNum = productDao.insertProduct(product1);
        assertEquals(1,effectedNum);
        effectedNum = productDao.insertProduct(product2);
        assertEquals(1,effectedNum);
        effectedNum = productDao.insertProduct(product3);
        assertEquals(1,effectedNum);

    }
    @Test
    public void testCQueryProductById(){
        long productId = 1;
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(productId);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int i = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2,i);
        Product product = productDao.queryProductById(productId);
        assertEquals(2,product.getProductImgList().size());
        int i1 = productImgDao.deleteProductImgByPorduct(productId);
        assertEquals(2,i1);

    }
    @Test
    public void testDUpdateProduct(){
        Product product = new Product();
        ProductCategory pc = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        pc.setProductCategoryId(16L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductName("改动一下啊");
        product.setProductCategory(pc);
        int i = productDao.updateProduct(product);
        assertEquals(1,i);
    }
    @Test
    public void testBQueryProductList(){
        Product productCondition = new Product();
        List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
        assertEquals(3,productList.size());
        int count = productDao.queryProductCount(productCondition);
        assertEquals(23,count);
        productCondition.setProductName("测试");
        productList = productDao.queryProductList(productCondition,0,4);
        assertEquals(4,productList.size());
        count = productDao.queryProductCount(productCondition);
        assertEquals(4,count);

    }
    @Test
    public void testEUpdateProductCategoryToNull(){
        int effectedNum = productDao.updateProductCategoryToNull(24L);
        assertEquals(16,effectedNum);
    }


}
