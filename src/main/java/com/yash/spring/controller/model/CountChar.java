package com.yash.spring.controller.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CountChar implements Serializable {
    private static final Long serialVersionUUID = 1L;
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    long count;

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    @Override
    public String toString() {
        return "CountChar{" + "count=" + count + '}';
    }

    public long getCount() {
        return count;
    }

    public void setCount(final long count) {
        this.count = count;
    }
}
