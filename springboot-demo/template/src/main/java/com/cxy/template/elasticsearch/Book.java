package com.cxy.template.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: template
 * @description:
 * @author: cuixy
 * @create: 2019-08-14 16:37
 **/
@Document(indexName = "book",type = "book")
public class Book {

    @Id
    private String id;
    private String name;
    private Double price;
    @Version
    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", price=" + price + ", version=" + version + "]";
    }

}