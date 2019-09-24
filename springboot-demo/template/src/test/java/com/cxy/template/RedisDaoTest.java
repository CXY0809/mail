package com.cxy.template;


import com.cxy.template.ehcache.RedisDao;
import com.cxy.template.mongodb.Department;
import com.cxy.template.mongodb.MongodbDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: template
 * @description: redis 测试类
 * @author: cuixy
 * @create: 2019-08-12 11:24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private MongodbDao mongodbDao;



//    @Test
//    public void testSet() {
//        Department department = new Department();
//        department.setId("1");
//        department.setName("2");
//        department.setDescr("3");
//
//        this.mongodbDao.insert(department);
//    }


//    @Test
//    public void testSet() {
//        String key = "name";
//        String value = "zhangsan";
//
//        this.redisDao.set(key, value);
//    }

    //@Test
    public void testGet() {
        String key = "name";
        String value = this.redisDao.get(key);
        System.out.println(value);
    }

    //@Test
    public void testDelete() {
        String key = "name";
        this.redisDao.delete(key);
    }
}