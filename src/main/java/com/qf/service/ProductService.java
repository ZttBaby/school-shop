package com.qf.service;

import com.qf.dto.ImageHolder;
import com.qf.dto.ProductExecution;
import com.qf.exceptions.ProductOperationException;
import com.qf.pojo.po.Product;

import java.io.InputStream;
import java.util.List;

public interface ProductService {
    ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> productImgHolderList) throws ProductOperationException;

    Product getProductById(long productId);

    ProductExecution modifyProduct(Product product,ImageHolder thumbnail,
                                   List<ImageHolder> productImgHolderList) throws ProductOperationException;
    ProductExecution getProductList(Product productCondition,int pageIndex,int pageSize);
}
