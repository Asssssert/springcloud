package com.iilei.provider.controller;

import com.iilei.api.entity.Dept;
import com.iilei.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping(value = "/provider/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping(value = "/provider/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping(value = "/provider/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }
}
