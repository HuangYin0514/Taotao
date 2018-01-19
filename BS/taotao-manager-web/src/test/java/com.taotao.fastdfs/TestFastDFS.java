package com.taotao.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;

public class TestFastDFS {

    @Test
    public void uploadFile() throws Exception{
        //1、向工程中添加jar包
        //2、创建一个配置文件。配置tracker服务器地址
        //3、加载配置文件
        ClientGlobal.init("C:/Users/10713/Documents/ideaFile/BS/taotao-manager-web/src/main/resources/resource/client.conf");
        //4、创建一个TrackClient对象
        TrackerClient trackerClient = new TrackerClient();
        //5、使用TrackClient对象获得tarckserver对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //6、创建要给StorageServer的引用null就可以
        StorageServer storageServer = null;
        //7、创建一个StorageClinet对象。tarckerserver StorageServer两个参数。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //8、使用StorageClient对象上传文件。
        String[] strings = storageClient.upload_file("C:/Users/10713/Pictures/DailyBeautifulPic/1.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
