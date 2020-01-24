package com.yash.spring.controller.model;

import java.io.Serializable;

public class OutputSentenceCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    private SentenceCount output;

    @Override
    public String toString() {
        return "OutputSentenceCount{" + "output='" + output + '\'' + '}';
    }

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    public SentenceCount getOutput() {
        return output;
    }

    public void setOutput(final SentenceCount output) {
        this.output = output;
    }
}
