package com.qf.util;

public class PathUtil {
    //获取文件的分隔符
    private static String seperator = System.getProperty("file.separator");
    public static String getImgBasePath(){

        //获取是什么系统
        String os = System.getProperty("os.name");
        String basePath ="";
        //如果是win系统就存存储的路径
        if(os.toLowerCase().startsWith("win")){
            basePath ="D:/img";
        }else {
            basePath = "/Users/cxx/Downloads";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }
    //根据业务需求返回图片的子路径
    public static String getShopImagePath(long shopId){
        String imagePath = "/images/item/shop/" + shopId +"/";
        return imagePath.replace("/",seperator);
    }

}
