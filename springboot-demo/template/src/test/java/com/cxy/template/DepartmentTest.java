package com.cxy.template;

import com.cxy.template.entity.Department;
import com.cxy.template.mysql.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void testInsert() {
        Department department = new Department();
        department.setId(2);
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