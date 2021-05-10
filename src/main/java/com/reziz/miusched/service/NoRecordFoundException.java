package com.reziz.miusched.service;

public class NoRecordFoundException extends RuntimeException {
    public NoRecordFoundException(String msg) {
        super(msg);
    }
    public NoRecordFoundException() {
        super();
    }
}
