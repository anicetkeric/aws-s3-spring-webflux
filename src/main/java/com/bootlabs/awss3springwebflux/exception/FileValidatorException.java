package com.bootlabs.awss3springwebflux.exception;

public class FileValidatorException extends RuntimeException {

    public FileValidatorException(String msg) {
        super(msg);
    }
}
