package com.cxy.template.controller.keyTools;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @program: authorization
 * @description: 压缩包文件校验
 * @author: cuixy
 * @create: 2020-05-06 14:23
 **/
@Controller
public class fileCheck {

    //公钥校验
    @Autowired
    private RSAUtilPbulicKey rSAUtilPbulicKey;


    public static void main(String[] args) throws Exception {
        new fileCheck().readZipFile("/Users/cuixiaoyan/Downloads/嘉士利科技有限公司.zip");
    }

    /**
     * 读取文件校验
     * @param filePath
     * @throws Exception
     */
    public String readZipFile(String filePath) throws Exception {
        //获取文件输入流
        FileInputStream input = new FileInputStream(filePath);
        //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));
        //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
        ZipEntry ze = null;
        //公钥
        String publicKey = "";
        //密文
        String cipher = "";
        //循环遍历
        while ((ze = zipInputStream.getNextEntry()) != null) {
            //读取
            BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream, Charset.forName("GBK")));
            String line;
            while ((line = br.readLine()) != null) {
                if (ze.getName().equals("publicKey.txt")) {
                    publicKey = line += "\n";
                }
                if (ze.getName().equals("cipher.txt")) {
                    cipher += line += "\n";
                }
            }
        }
        //获取明文
        //String clear = rSAUtilPbulicKey.decryptByPublicKey(publicKey, cipher);
        zipInputStream.closeEntry();
        input.close();
        return null;
    }

}