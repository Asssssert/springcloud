package com.iilei.provider8002.controller;

import com.iilei.api.entity.Dept;
import com.iilei.provider8002.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping(value = "/dept/discovery")
    public Object discovery() {
        return this.discoveryClient;
    }

}
