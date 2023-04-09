package com.myapp.common.commons;

import com.myapp.common.responseDto.ApiResponse;
import org.springframework.http.HttpStatus;

public interface GetResponse {
    ApiResponse getSuccessfulResponse(HttpStatus status, Object data, String error);

    ApiResponse getErrorResponse(HttpStatus status, Object data, String error);

}
