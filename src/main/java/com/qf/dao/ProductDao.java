package com.qf.dao;

import com.qf.pojo.po.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    //查询商品列表并分页，可输入的条件；商品名/商品状态/店铺Id/商品类别
    List<Product> queryProductList(@Param("productCondition") Product productCondition,@Param("rowIndex") int rowIndex,
                                   @Param("pageSize") int pageSize);
    //查询对应的商品总数
    int queryProductCount(@Param("productCondition") Product productCondition);
    //插入商品
     int insertProduct(Product product);
     //查询商品
    Product queryProductById(long productId);
    //更新商品
    int updateProduct(Product product);
    //删除商品类别之前，将商品类别Id置为空
    int updateProductCategoryToNull(long prductCategoryId);

}
