package com.iilei.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long id;
    private String name;
    private String db_source;

    public Dept(String name) {
        this.name = name;
    }
}
