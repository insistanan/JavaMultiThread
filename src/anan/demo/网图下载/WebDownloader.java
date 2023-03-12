package demo.网图下载;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//下载器
public class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            String path =System.getProperty("user.dir") + "\\src\\anan\\demo\\网图下载\\img\\";
            FileUtils.copyURLToFile(new URL(url),new File(path + name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题！");
        }
    }
}