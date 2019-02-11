package com.qf.service;

import com.qf.BaseTest;
import com.qf.dto.ImageHolder;
import com.qf.dto.ShopExecution;
import com.qf.enums.ShopStateEnum;
import com.qf.exceptions.ShopOperationException;
import com.qf.pojo.po.Area;
import com.qf.pojo.po.PersonInfo;
import com.qf.pojo.po.Shop;
import com.qf.pojo.po.ShopCategory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void testGetShopList(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(2L);
        shopCondition.setShopCategory(sc);
        ShopExecution shopList = shopService.getShopList(shopCondition, 1, 1);
        System.out.println(shopList.getShopList().size());
        System.out.println(shopList.getCount());
    }

    @Test
    @Ignore
    public void testModifyShop() throws ShopOperationException ,FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopId(23L);
        shop.setShopName("我就是大帅比");
        File shopImg = new File("/Users/cxx/Downloads/img/1.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder("1.jpg",is);

        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
        System.out.println("新的店铺地址"+shopExecution.getShop().getShopImg());
    }
    @Test
    @Ignore
    public void testAddShop() throws FileNotFoundException {
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
        shop.setShopName("测试店铺7");
        shop.setShopDesc("test66");
        shop.setShopAddr("test66");
        shop.setPhone("test66");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        File shopImg = new File("/Users/cxx/Downloads/img/1.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
        ShopExecution se = shopService.addShop(shop,imageHolder);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
