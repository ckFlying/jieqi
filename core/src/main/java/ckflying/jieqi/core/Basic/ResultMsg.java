package ckflying.jieqi.core.Basic;

import entity.Result;

import java.util.List;

/**
 * create by wjwang on 2018/10/24
 */
public class ResultMsg<T> extends Result {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
