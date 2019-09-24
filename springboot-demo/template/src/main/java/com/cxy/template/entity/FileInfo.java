package com.cxy.template.entity;

/**
 * @program: template
 * @description: 文件上传下载实体类
 * @author: cuixy
 * @create: 2019-08-08 16:28
 **/
public class FileInfo {

    //文件上传路径
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}