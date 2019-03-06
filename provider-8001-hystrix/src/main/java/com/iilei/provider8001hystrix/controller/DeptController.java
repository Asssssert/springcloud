package com.iilei.provider8001hystrix.controller;

import com.iilei.api.entity.Dept;
import com.iilei.provider8001hystrix.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "errorReq")// 如果当前调用的get()方法出现了错误，则执行fallback
    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("不存在");
        }
        return dept;
    }

//    @HystrixCommand(fallbackMethod = "errorReq")// 如果当前调用的get()方法出现了错误，则执行fallback
//    @GetMapping(value = "/dept/get/{id}")
//    public JsonData get(@PathVariable Long id) {
//        Dept dept = deptService.get(id);
//        if(dept==null){
//            throw new RuntimeException("不存在");
//        }
//        return JsonData.success(dept);
//    }

    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping(value = "/dept/discovery")
    public Object discovery() {
        return this.discoveryClient;
    }

    public Dept errorReq(@PathVariable Long id) { // 此时方法的参数 与get()一致
        return new Dept().setId(id).setDb_source("no db").setName("error req");
    }

//    public JsonData errorReq(@PathVariable Long id) { // 此时方法的参数 与get()一致
//        return JsonData.fail(403,"ID:"+id+"请求失败");
//    }

}
