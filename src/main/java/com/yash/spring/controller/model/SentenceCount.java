package com.yash.spring.controller.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

public class SentenceCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    long sentenceCount;

    @Override
    public String toString() {
        return "SentenceCount{" + "sentenceCount=" + sentenceCount + '}';
    }

    public long getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(final long sentenceCount) {
        this.sentenceCount = sentenceCount;
    }
}
