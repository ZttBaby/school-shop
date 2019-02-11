package com.qf.util;

import com.qf.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

//水印工具类
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
        //随机生产的文件名
        String realFileName = getRandomFileName();
        //获取到扩展名(.jpg...)
        String extension = getFileExtension(thumbnail.getImageName());
        //如果文件不存在，自动创建
        makeDirPath(targetAddr);
        //获取文件存储的相对路径
        String relativeAddr = targetAddr + realFileName + extension;
        //获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        //调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
                    .outputQuality(0.25f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        //返回图片相对路径地址
        return relativeAddr;
    }

    //创建目标路径所涉及到的目录
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
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

    /*storePath是文件的路径还是目录的路径
     * 　如果storePath是文件路径则删除该文件，
     * 如果storePath是目录路径则删除该目录下的所有文件*/
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }

    }

    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
        //随机生产的文件名
        String realFileName = getRandomFileName();
        //获取到扩展名(.jpg...)
        String extension = getFileExtension(thumbnail.getImageName());
        //如果文件不存在，自动创建
        makeDirPath(targetAddr);
        //获取文件存储的相对路径
        String relativeAddr = targetAddr + realFileName + extension;
        //获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        //调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        //返回图片相对路径地址
        return relativeAddr;
    }


}


