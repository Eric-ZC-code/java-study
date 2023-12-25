package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询全部部门信息");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id刪除部門：{}", id);
        deptService.delete(id);
        return  Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryByID(@PathVariable Integer id) {
        log.info("根据id查询部门信息：{}", id);
        Dept dept = deptService.queryByID(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("更新查询的部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
