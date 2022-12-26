package com.bootlabs.awss3springwebflux.domain;

import software.amazon.awssdk.services.s3.model.CompletedPart;

import java.util.HashMap;
import java.util.Map;

public class UploadStatus {
    private final String fileKey;

    private final String contentType;

    private String uploadId;
    private int partCounter;
    private int buffered;

    private Map<Integer, CompletedPart> completedParts = new HashMap<>();

    public UploadStatus(String contentType, String fileKey) {
        this.contentType = contentType;
        this.fileKey = fileKey;

        this.buffered = 0;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFileKey() {
        return fileKey;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public int getPartCounter() {
        return partCounter;
    }

    public void setPartCounter(int partCounter) {
        this.partCounter = partCounter;
    }

    public int getBuffered() {
        return buffered;
    }

    public void setBuffered(int buffered) {
        this.buffered = buffered;
    }

    public Map<Integer, CompletedPart> getCompletedParts() {
        return completedParts;
    }

    public void setCompletedParts(Map<Integer, CompletedPart> completedParts) {
        this.completedParts = completedParts;
    }

    public void addBuffered(int buffered) {
        this.buffered += buffered;
    }

    public int getAddedPartCounter() {
        return ++this.partCounter;
    }
}
