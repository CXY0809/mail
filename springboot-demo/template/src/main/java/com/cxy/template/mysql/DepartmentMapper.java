package com.cxy.template.mysql;


import com.cxy.template.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 不需要暂时注释掉 影响初始化
 */
@Mapper
public interface DepartmentMapper {

    public void insert(Department department);

    public void insertDepartmentList(@Param("departmentList")  List<Department> departmentList);

    public Department getById(Integer id);

    public void update(Department department);

    public void deleteById(Integer id);
}

