package com.iilei.api.service;

import com.iilei.api.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setId(id).setName("该微服务进行了降级处理，服务已关闭").setDb_source("close");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
