package com.cxy.template.ehcache;

import com.cxy.template.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: template
 * @description: 控制层 controller
 * @author: cuixy
 * @create: 2019-08-12 10:41
 **/
@Controller
@RequestMapping("department")
@ResponseBody
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("save")
    public Map<String,Object> save(Department department) {
        this.departmentService.save(department);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "保存成功");
        return map;
    }

    @RequestMapping("get/{id}")
    public Map<String,Object> get(@PathVariable("id") Integer id) {
        Department department = this.departmentService.getDepartmentById(id);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "获取成功");
        map.put("data", department);
        return map;
    }

    @RequestMapping("update")
    public Map<String,Object> update(Department department) {
        this.departmentService.update(department);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "修改成功");
        return map;
    }

    @RequestMapping("delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id) {
        this.departmentService.delete(id);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        return map;
    }
}