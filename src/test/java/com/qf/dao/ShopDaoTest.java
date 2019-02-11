package com.qf.dao;

import com.qf.BaseTest;
import com.qf.pojo.po.Area;
import com.qf.pojo.po.PersonInfo;
import com.qf.pojo.po.Shop;
import com.qf.pojo.po.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.acl.Owner;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopList(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 2);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺的总数" + shopList.size());
        System.out.println("店铺的大小" + count);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(2L);
        shopCondition.setShopCategory(shopCategory);
        shopList = shopDao.queryShopList(shopCondition, 0, 1);
        count = shopDao.queryShopCount(shopCondition);
        System.out.println("x店铺的总数" + shopList.size());
        System.out.println("x店铺的大小" + count);

    }
    @Test
    @Ignore
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(8L);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1,effectedNum);




    }
    @Test
    @Ignore
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("测试地址");
        shop.setShopDesc("测试描述");
        shop.setCreateTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }
    @Test
    @Ignore
    public void testQueryByShopId(){
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId==" + shop.getArea().getAreaId());
        System.out.println("areaName==" + shop.getArea().getAreaName());
    }

}
