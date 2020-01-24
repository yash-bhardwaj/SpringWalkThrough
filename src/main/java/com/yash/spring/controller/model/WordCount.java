package com.yash.spring.controller.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

public class WordCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    long wordCount;

    public static Long getSerialVersionUUID() {
        return serialVersionUUID;
    }

    @Override
    public String toString() {
        return "WordCount{ wordCount=" + wordCount + '}';
    }

    public long getWordCount() {
        return wordCount;
    }

    public void setWordCount(final long wordCount) {
        this.wordCount = wordCount;
    }
}
