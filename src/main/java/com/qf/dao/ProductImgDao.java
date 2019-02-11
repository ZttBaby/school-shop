package com.qf.dao;

import com.qf.pojo.po.ProductImg;

import java.util.List;

public interface ProductImgDao {
    //根据ID查询详情图
    List<ProductImg> queryProductImgList(long productId);
    //批量添加商品图片
    int batchInsertProductImg(List<ProductImg> productImgList);
    //删除指定商品下的所有详情图
    int deleteProductImgByPorduct(long productId);
}
