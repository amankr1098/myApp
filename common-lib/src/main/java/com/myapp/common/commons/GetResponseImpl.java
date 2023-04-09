package com.myapp.common.commons;

import com.myapp.common.responseDto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class GetResponseImpl implements GetResponse {
    @Override
    public ApiResponse getSuccessfulResponse(HttpStatus status, Object data, String error) {
        return ApiResponse.builder()
                .status(status)
                .error(error)
                .data(data)
                .build();
    }

    @Override
    public ApiResponse getErrorResponse(HttpStatus status, Object data, String error) {
        return ApiResponse.builder()
                .status(status)
                .error(error)
                .data(data)
                .build();
    }
}
