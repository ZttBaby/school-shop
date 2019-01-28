package com.qf.service.impl;

import com.qf.dao.ShopDao;
import com.qf.enums.ShopStateEnum;
import com.qf.exceptions.ShopOperationException;
import com.qf.pojo.po.Shop;
import com.qf.service.ShopService;
import com.qf.util.ImageUtil;
import com.qf.util.PathUtil;
import com.qf.dto.ShopExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;


    @Override
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {
        //空值判断
        //如果为空返回枚举类型
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        //not null
        try{
            //给店铺信息赋初始值
            //返回状态：0 ==》 审核中
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺的信息
            int effectedNum = shopDao.insertShop(shop);
            //判断店铺插入是否成功：
            if (effectedNum <= 0){
                //使用运行是异常如果操作失败执行事务的回滚
                throw new ShopOperationException("店铺创建失败");
            }else{
                if(shopImgInputStream !=null){
                    //存储图片
                    try{
                        addShopImg(shop, shopImgInputStream,fileName);
                    }catch (Exception e){
                        throw new ShopOperationException("addShop error:" + e.getMessage());
                    }
                    //更新店的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }

                }
            }
        }catch(Exception e){
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }


        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAdder = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAdder);
    }
}
