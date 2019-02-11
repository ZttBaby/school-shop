package com.qf.dao;

import com.qf.pojo.po.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    //返回查询的总数
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
    /*分页查询店铺 从第几行开始取返回多少条数
    * 条件：店铺名（模糊）  店铺状态 区域ID、owner
    * */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,@Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);
    //查询店铺
    Shop queryByShopId(long shoId);
    //新增店铺
    int insertShop(Shop shop);
    //更新店铺
    int updateShop(Shop shop);
}
