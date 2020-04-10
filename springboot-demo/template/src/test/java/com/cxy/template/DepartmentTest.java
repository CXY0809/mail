package com.cxy.template;

import com.cxy.template.ehcache.RedisDao;
import com.cxy.template.entity.Department;
import com.cxy.template.mysql.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: template
 * @description: mybatis 测试类
 * @author: cuixy
 * @create: 2019-08-09 14:47
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisDao redisDao;

    //写入mysql时间： 4ms
    //写入redis时间： 78055ms

    //直接批量写入mysql
    //写入mysql时间： 4ms

    //单条写入mysql
    //写入mysql时间： 258971ms
    @Test
    public void CreateCollection() {
        long startTime = System.currentTimeMillis();
        ArrayList<Department> departmentList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Department department = new Department();
            department.setId(i);
            department.setName("研1发部" + i);
            department.setDescr("开1发产品" + i);
            //单条记录新增插入
            //departmentMapper.insert(department);

            //redis新增
            //redisDao.set(department.getId().toString(), department.getName());
            departmentList.add(department);
        }
        long endTime = System.currentTimeMillis();
        TraverseCollection(departmentList);
        System.out.println("集合生成加redis写入缓存时间： " + (endTime - startTime) + "ms");

    }

    public void TraverseCollection(ArrayList<Department> departmentList) {
        long startTime = System.currentTimeMillis();
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run(){
                //批量新增mysql
                departmentMapper.insertDepartmentList(departmentList);
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println("集合解析加写入mysql时间： " + (endTime - startTime) + "ms");
    }


    //@Test
    public void NewOptimization() {

        // 254277毫秒，4分钟
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            Department department = new Department();
//            department.setId(i);
//            department.setName("研1发部" + i);
//            department.setDescr("开1发产品" + i);
//            this.departmentMapper.insert(department);
//            this.redisDao.set(department.getId().toString(), department.getName());
//        }
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");


        //64967毫秒，1分钟。
//        long startTime = System.currentTimeMillis();
//
//        ArrayList<Department> departmentList = new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            Department department = new Department();
//            department.setId(i);
//            department.setName("研1发部" + i);
//            department.setDescr("开1发产品" + i);
//            departmentList.add(department);
//            this.redisDao.set(department.getId().toString(), department.getName());
//        }
//
//        this.departmentMapper.insertDepartmentList(departmentList);
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");


        //81596毫秒，1.2分钟。
        long startTime = System.currentTimeMillis();
        ArrayList<Department> departmentList = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Department department = new Department();
            department.setId(i);
            department.setName("研1发部" + i);
            department.setDescr("开1发产品" + i);
            departmentList.add(department);
            redisDao.set(department.getId().toString(), department.getName());
        }

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                departmentMapper.insertDepartmentList(departmentList);
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");


    }


    //@Test
    public void testInsert() {
        Department department = new Department();
        department.setId(20);
        department.setName("研1发部");
        department.setDescr("开1发产品");
        this.departmentMapper.insert(department);
    }

    //@Test
    public void testGetById() {
        Department department = this.departmentMapper.getById(1);
        System.out.println(department);
    }

    //@Test
    public void testUpdate() {
        Department department = new Department();
        department.setId(1);
        department.setDescr("开发高级产品");
        this.departmentMapper.update(department);
    }

    //@Test
    public void testDeleteById() {
        this.departmentMapper.deleteById(1);
    }
}