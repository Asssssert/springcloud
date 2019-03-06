package com.iilei.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果封装
 */
@Getter
@Setter
public class JsonData {
    private Integer code;
    private String msg;
    private Object data;

    //成功、返回消息和数据
    public static JsonData success(String msg, Object data) {
        JsonData jsonData = new JsonData(200);
        jsonData.data = data;
        jsonData.msg = msg;
        return jsonData;
    }

    //成功、无返回消息
    public static JsonData success(Object data) {
        JsonData jsonData = new JsonData(200);
        jsonData.data = data;
        return jsonData;
    }

    //成功、无返回数据
    public static JsonData success(String msg) {
        JsonData jsonData = new JsonData(200);
        jsonData.msg = msg;
        return jsonData;
    }

    //成功、无返回数据、消息
    public static JsonData success() {
        JsonData jsonData = new JsonData(200);
        return jsonData;
    }

    //返回结果失败
    public static JsonData fail(Integer code, String msg) {
        JsonData jsonData = new JsonData(code);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }

    public JsonData(Integer code) {
        this.code = code;
    }
}
