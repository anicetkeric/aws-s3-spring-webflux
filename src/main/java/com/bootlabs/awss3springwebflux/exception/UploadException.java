package com.bootlabs.awss3springwebflux.exception;

public class UploadException extends RuntimeException {

    public UploadException(String msg) {
        super(msg);
    }
}
