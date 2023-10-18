package com.wanted.preonboarding.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataDto<T> {

    public String code;
    public String message;
    public T data;

}
