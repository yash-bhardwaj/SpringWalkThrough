package com.yash.spring.controller.model;

import java.io.Serializable;

public class InputModel implements Serializable {
    private static final Long serialVersionUUID = 1L;
    private TextModel input;

    @Override
    public String toString() {
        return "InputModel{" + "input='" + input + '\'' + '}';
    }

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    public TextModel getInput() {
        return input;
    }

    public void setInput(final TextModel input) {
        this.input = input;
    }
}
