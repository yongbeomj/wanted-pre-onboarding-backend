package com.wanted.preonboarding.util;

import com.wanted.preonboarding.dto.common.ResponseDto;
import org.springframework.http.HttpStatus;

public class ResponseUtil {

    public static <T> ResponseDto<T> success(T response) {
        return new ResponseDto<>("000", "success", "");
    }

    public static ResponseDto<?> error(Throwable throwable, HttpStatus status) {
        return new ResponseDto<>("999","error", throwable);
    }

}
