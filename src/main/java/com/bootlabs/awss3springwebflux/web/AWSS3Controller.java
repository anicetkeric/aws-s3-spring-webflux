package com.bootlabs.awss3springwebflux.web;

import com.bootlabs.awss3springwebflux.common.FileUtils;
import com.bootlabs.awss3springwebflux.domain.SuccessResponse;
import com.bootlabs.awss3springwebflux.service.AWSS3FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

@RequiredArgsConstructor
@RestController
@RequestMapping("/object")
@Validated
public class AWSS3Controller {

    private final AWSS3FileStorageService fileStorageService;

    @PostMapping("/upload")
    public Mono<SuccessResponse> upload(@RequestPart("file-data") Mono<FilePart> filePart) {
        return filePart
                .map(file -> {
                    FileUtils.filePartValidator(file);
                    return file;
                })
                .flatMap(fileStorageService::uploadObject)
                .map(fileResponse -> new SuccessResponse(fileResponse, "Upload successfully"));
    }

    @GetMapping(path="/{fileKey}")
    public Mono<SuccessResponse> download(@PathVariable("fileKey") String fileKey) {

        return fileStorageService.getByteObject(fileKey)
                .map(objectKey -> new SuccessResponse(objectKey, "Object byte response"));
    }

    @DeleteMapping(path="/{objectKey}")
    public Mono<SuccessResponse> deleteFile(@PathVariable("objectKey") String objectKey) {
        return fileStorageService.deleteObject(objectKey)
                .map(resp -> new SuccessResponse(null, MessageFormat.format("Object with key: {0} deleted successfully", objectKey)));
    }

    @GetMapping
    public Flux<SuccessResponse> getObject() {
        return fileStorageService.getObjects()
                .map(objectKey -> new SuccessResponse(objectKey, "Result found"));
    }
}
