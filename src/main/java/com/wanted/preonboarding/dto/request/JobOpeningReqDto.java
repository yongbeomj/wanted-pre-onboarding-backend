package com.wanted.preonboarding.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningReqDto {

    private long jobId;
    private Long companyId;
    private String position;
    private int reward;
    private String content;
    private String skill;

}
