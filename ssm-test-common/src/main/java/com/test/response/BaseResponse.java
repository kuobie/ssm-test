package com.test.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 淘淘商城自定义响应结构
 */
@Getter
@Setter
public class BaseResponse {


    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static BaseResponse build(Integer status, String msg, Object data) {
        return new BaseResponse(status, msg, data);
    }

    public static BaseResponse ok(Object data) {
        return new BaseResponse(data);
    }

    public static BaseResponse ok() {
        return new BaseResponse(null);
    }

    public BaseResponse() {

    }

    public static BaseResponse build(Integer status, String msg) {
        return new BaseResponse(status, msg, null);
    }

    public BaseResponse(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }



}
