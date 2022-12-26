package com.bootlabs.awss3springwebflux.domain;

public record FileResponse(String name, String uploadId, String path, String type, String eTag) {}
