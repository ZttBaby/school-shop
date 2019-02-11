package com.qf.service;

import com.qf.dto.ProductCategoryExecution;
import com.qf.exceptions.ProductCategoryOperationException;
import com.qf.pojo.po.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getProductCateList(long shopId);

    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
        throws ProductCategoryOperationException;

    //将此类别下的商品里的类别id置为空，再删除掉该商品的类别
    ProductCategoryExecution deleteProductCategory(long productCategoryId,  long shopId)
            throws ProductCategoryOperationException;

}
