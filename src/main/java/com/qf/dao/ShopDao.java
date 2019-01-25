package com.qf.dao;

import com.qf.pojo.po.Shop;

public interface ShopDao {
    //新增店铺
    int insertShop(Shop shop);
    //更新店铺
    int updateShop(Shop shop);
}
