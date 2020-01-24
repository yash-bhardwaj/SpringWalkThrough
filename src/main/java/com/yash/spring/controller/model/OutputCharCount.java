package com.yash.spring.controller.model;

import java.io.Serializable;

public class OutputCharCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    private CountChar output;

    @Override
    public String toString() {
        return "OutputCharCount{" + "output='" + output + '\'' + '}';
    }

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    public CountChar getOutput() {
        return output;
    }

    public void setOutput(final CountChar output) {
        this.output = output;
    }
}
