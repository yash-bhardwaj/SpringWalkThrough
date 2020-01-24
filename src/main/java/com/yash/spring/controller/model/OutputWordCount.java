package com.yash.spring.controller.model;

import java.io.Serializable;

public class OutputWordCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    private WordCount output;

    @Override
    public String toString() {
        return "OutputWordCount{" + "output='" + output + '\'' + '}';
    }

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    public WordCount getOutput() {
        return output;
    }

    public void setOutput(final WordCount output) {
        this.output = output;
    }
}
