package com.wanted.preonboarding.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDataDto<T> {

    public String code;
    public String message;
    public T data;

    public ResponseDataDto(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseDataDto<T> ok() {
        return new ResponseDataDto<>("", "", null);
    }

    public static <T> ResponseDataDto<T> ok(T data) {
        return new ResponseDataDto<>("000", "success", data);
    }

}
