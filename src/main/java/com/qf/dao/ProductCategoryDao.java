package com.qf.dao;

import com.qf.pojo.po.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    //查询商品类别
    List<ProductCategory> queryProductCategoryList(long shopId);
    //批量插入商品类
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);
    //批量删除商品类别
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId,@Param("shopId") long shopId);
}
