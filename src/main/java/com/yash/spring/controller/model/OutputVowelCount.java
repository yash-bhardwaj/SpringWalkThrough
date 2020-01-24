package com.yash.spring.controller.model;

import java.io.Serializable;

public class OutputVowelCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    private VowelCount output;

    @Override
    public String toString() {
        return "OutputSentenceCount{" + "output='" + output + '\'' + '}';
    }

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    public VowelCount getOutput() {
        return output;
    }

    public void setOutput(final VowelCount output) {
        this.output = output;
    }
}
