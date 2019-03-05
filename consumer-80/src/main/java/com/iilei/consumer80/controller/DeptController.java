package com.iilei.consumer80.controller;

import com.iilei.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private RestTemplate restTemplate;
    public static final String REST_API_PREFIX = "http://PROVIDER-DEPT";


    @PostMapping(value = "/consumer/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_API_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping(value = "/consumer/get/{id}")
    public Dept get(@PathVariable Long id) {
        return restTemplate.getForObject(REST_API_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping(value = "/consumer/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_API_PREFIX + "/dept/list", List.class);
    }

}
