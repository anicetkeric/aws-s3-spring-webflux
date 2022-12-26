package com.bootlabs.awss3springwebflux.service;

import com.bootlabs.awss3springwebflux.domain.AWSS3Object;
import com.bootlabs.awss3springwebflux.domain.FileResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AWSS3FileStorageService {

    /**
     * Upload object in Amazon S3
     * @param filePart - the request part containing the file to be saved
     * @return Mono of {@link FileResponse} representing the result of the operation
     */
    Mono<FileResponse> uploadObject(FilePart filePart);

    /**
     * Retrieves byte objects from Amazon S3.
     * @param key object key
     * @return object byte[]
     */
    Mono<byte[]> getByteObject(@NotNull String key);

    /**
     * Delete multiple objects from a bucket
     * @param objectKey object key
     */
    Mono<Void> deleteObject(@NotNull String objectKey);

    /**
     * Returns some or all (up to 1,000) of the objects in a bucket.
     * @return Flux of object key
     */
    Flux<AWSS3Object> getObjects();
}
