package com.xr.util;
import java.util.HashMap;
import java.util.Map;

public class ResponseResult {
    private Integer code = 20000; // 返回到前端的状态码，20000表示成功
    private Map<String,Object> data = new HashMap<>(); // 返回到前端的数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
