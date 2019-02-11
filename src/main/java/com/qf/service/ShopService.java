package com.qf.service;

import com.qf.dto.ImageHolder;
import com.qf.exceptions.ShopOperationException;
import com.qf.pojo.po.Shop;
import com.qf.dto.ShopExecution;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

public interface ShopService {

    //获取店铺列表（前端只认页数，后端只认行数）
    ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);

    //根据店铺Id获取店铺信息
    Shop getByShopId(long shopId);
    //更新店铺信息，包括对图片对处理
    ShopExecution modifyShop(Shop shop,ImageHolder thumbnail)throws ShopOperationException;
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
