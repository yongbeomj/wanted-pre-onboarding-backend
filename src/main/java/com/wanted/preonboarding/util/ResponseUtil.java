package com.wanted.preonboarding.util;

import com.wanted.preonboarding.dto.common.ResponseDataDto;
import com.wanted.preonboarding.dto.common.ResponseDto;

public class ResponseUtil {

    public static ResponseDto success() {
        return new ResponseDto("000", "success");
    }

    public static <T> ResponseDataDto<T> success(T response) {
        return new ResponseDataDto<>("000", "success", response);
    }

    public static ResponseDto error(String throwable) {
        return new ResponseDto("999", throwable);
    }

}
