package com.wanted.preonboarding.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto<T> {

    private String code;
    private String status;
    private String message;

    public ResponseDto(String code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public ResponseDto(String code, String status, Throwable throwable) {
        this(code, status, throwable.getMessage());
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
