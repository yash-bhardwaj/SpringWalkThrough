package com.yash.spring.controller.model;

import java.io.Serializable;

public class TextModel implements Serializable {
    private static final Long serialVersionUUID = 1L;
    String text;

    public String getText() {
        return text;
    }

    public TextModel setText(final String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "TextModel{" + "text='" + text + '\'' + '}';
    }
}
