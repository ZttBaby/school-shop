package com.qf.dao;

import com.qf.BaseTest;
import com.qf.pojo.po.ProductImg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductImgDaoTest extends BaseTest {
    @Autowired
    private ProductImgDao productImgDao;
    @Test
    public void testABatchInsertProductImg(){
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setImgDesc("测试图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1L);
        List<ProductImg> productImgList = new ArrayList<>();
       productImgList.add(productImg1);
       productImgList.add(productImg2);
       int effectedNum = productImgDao.batchInsertProductImg(productImgList);
       assertEquals(2,effectedNum);
    }
    @Test
    public void testCDeleteProductImgByPorduct(){
        long productId = 1;
        int i = productImgDao.deleteProductImgByPorduct(productId);
        assertEquals(2,i);
    }

    @Test
    public void testCqueryProductImgList(){
        long productId = 11L;
        List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);
        assertEquals(2,productImgList.size());
    }
}
