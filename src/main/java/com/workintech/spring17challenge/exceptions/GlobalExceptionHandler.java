package com.workintech.spring17challenge.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

 @Slf4j
 @ControllerAdvice
 public class GlobalExceptionHandler {

        @ExceptionHandler(ApiException.class)
        public ResponseEntity<ApiResponseError> handleException(ApiException apiException)
        {
            ApiResponseError errorResponse = new ApiResponseError(
                    apiException.getHttpStatus().value(),
                    apiException.getMessage(),
                    System.currentTimeMillis());
                    log.warn("Exception: " + apiException);
            return new ResponseEntity<ApiResponseError>(errorResponse,apiException.getHttpStatus());
        }


        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponseError> handleException(Exception exception)
        {
            ApiResponseError responseError = new ApiResponseError(
                     HttpStatus.BAD_REQUEST.value(),
                     exception.getMessage(),
                     System.currentTimeMillis());
            return new ResponseEntity<ApiResponseError>(responseError, HttpStatus.BAD_REQUEST);
        }

    }