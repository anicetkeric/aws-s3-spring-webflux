package com.bootlabs.awss3springwebflux.common;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.SdkResponse;

@UtilityClass
@Slf4j
public class AwsSdkUtil {

    public boolean isErrorSdkHttpResponse(SdkResponse sdkResponse) {
        return sdkResponse.sdkHttpResponse() == null || !sdkResponse.sdkHttpResponse().isSuccessful();
    }
}
