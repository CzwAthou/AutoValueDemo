package com.athou.autovaluedemo.bean;

/**
 * Created by athou on 2017/3/20.
 */

public class ParentStoy<T> {
    private int code;
    private T result;
    private String err;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
