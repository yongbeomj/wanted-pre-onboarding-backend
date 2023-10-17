package com.wanted.preonboarding.util;

import com.wanted.preonboarding.dto.common.ResponseDataDto;
import com.wanted.preonboarding.dto.common.ResponseDto;
import org.springframework.http.HttpStatus;

public class ResponseUtil {

    public static <T> ResponseDto<T> success() {
        return new ResponseDto<>("000", "success", "");
    }

    public static <T> ResponseDataDto<T> success(T response) {
        return new ResponseDataDto<>("000", "success", response);
    }

    public static ResponseDto<?> error(Throwable throwable, HttpStatus status) {
        return new ResponseDto<>("999","error", throwable);
    }

}
