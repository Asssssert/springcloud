package com.iilei.consumerfeign80.controller;

import com.iilei.api.entity.Dept;
import com.iilei.api.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @PostMapping(value = "/consumer/add")
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping(value = "/consumer/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping(value = "/consumer/list")
    public List<Dept> list() {
        return deptService.list();
    }

}
