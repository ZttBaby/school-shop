package com.qf.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//水印工具类
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr) {
        //随机生产的文件名
        String realFileName = getRandomFileName();
       //获取到扩展名
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        System.out.println(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
                    .outputQuality(0.25f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }
    //创建目标路径所涉及到的目录
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath()+ targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    //获取输入文件流的扩展名(.jpg  .png)
    private static String getFileExtension(String fileName) {
//        String originalFileName = cFile.getName();
        return fileName.substring(fileName.lastIndexOf("."));

    }

    //生成随机文件名，当前年月日小时分秒+五位随机数
    public static String getRandomFileName() {
        //获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }


    public static void main(String[] args) throws IOException {
        //图像处理文件的路径
        Thumbnails.of(new File("/Users/cxx/Downloads/img/3.jpg"))
                //设置大小
                .size(200, 200)
                //设置水印的参数（位置，读入水印的位置，透明比）
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
                //压缩图片比例
                .outputQuality(0.8f)
                //输出水印图片的位置
                .toFile("/Users/cxx/Downloads/img/5.jpg");
    }
}
