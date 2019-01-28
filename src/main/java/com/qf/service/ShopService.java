package com.qf.service;

import com.qf.exceptions.ShopOperationException;
import com.qf.pojo.po.Shop;
import com.qf.dto.ShopExecution;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
}
