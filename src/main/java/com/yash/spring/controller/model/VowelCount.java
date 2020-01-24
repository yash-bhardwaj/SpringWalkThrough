package com.yash.spring.controller.model;

import java.io.Serializable;

public class VowelCount implements Serializable {
    private static final Long serialVersionUUID = 1L;
    int a;
    int e;
    int i;
    int o;
    int u;

    @Override
    public String toString() {
        return "VowelCount{" + "a='" + a + '\'' + ", e='" + e + '\'' + ", i='" + i + '\'' + ", o='" + o + '\'' + ", u='"
                + u + '\'' + '}';
    }

    public int getA() {
        return a;
    }

    public void setA(final int a) {
        this.a = a;
    }

    public int getE() {
        return e;
    }

    public void setE(final int e) {
        this.e = e;
    }

    public int getI() {
        return i;
    }

    public void setI(final int i) {
        this.i = i;
    }

    public int getO() {
        return o;
    }

    public void setO(final int o) {
        this.o = o;
    }

    public int getU() {
        return u;
    }

    public void setU(final int u) {
        this.u = u;
    }
}
