package com.cxy.template.mysql;


import com.cxy.template.entity.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * 不需要暂时注释掉 影响初始化
 */
//@Mapper
public interface DepartmentMapper {

    public void insert(Department department);

    public Department getById(Integer id);

    public void update(Department department);

    public void deleteById(Integer id);
}

