package com.iilei.api.service;

import com.iilei.api.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
    @PostMapping(value = "/dept/add")
    public boolean add(Dept dept);

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();
}
