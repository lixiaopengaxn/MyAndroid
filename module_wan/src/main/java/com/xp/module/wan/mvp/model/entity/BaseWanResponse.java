package com.xp.module.wan.mvp.model.entity;

import java.io.Serializable;

/**
 * ...--,       .--,
 * .( (  \.---./  ) )
 * ..'.__/o   o\__.'
 * .....{=  ^  =}
 * ......>  -  <
 * ...../       \
 * ....//       \\
 * ...//|   .   |\\
 * ..."'\       /'"_.-~^`'-.
 * ......\  _  /--'         `
 * ....___)( )(___
 * ...(((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 *
 * @author lipeng
 * @title: BaseWanResponse
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/272:47 PM
 */
public class BaseWanResponse<T> implements Serializable {

    private String errorMsg;
    private int errorCode;
    private T data;

    public String getMsg() {
        return errorMsg;
    }

    public void setMsg(String msg) {
        this.errorMsg = msg;
    }

    public int getCode() {
        return errorCode;
    }

    public void setCode(int code) {
        this.errorCode = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseWanResponse{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorCode=" + errorCode +
                ", data=" + data +
                '}';
    }
}
