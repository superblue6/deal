package com.kuaipao.commen.utils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class OssTemplate {
    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.accessKeyId}")
    private String accessKeyId;
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${oss.bucketName}")
    private String bucketName;
    @Value("${oss.objectName}")
    private String objectName;

    /**
     *  上传文件至阿里云
     * @param inputStream
     * @param fileName
     * @return 返回文件访问路径
     */
    public String upload(InputStream inputStream,String fileName){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String folderName = dateFormat.format(new Date());
        fileName = UUID.randomUUID().toString().replace("-", "") + "_" + fileName;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName,"pic/"+folderName+"/"+fileName,inputStream);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ossClient.shutdown();
        String url="https://"+objectName+"/"+"pic/"+folderName+"/"+fileName;
        return url;
    }
}
