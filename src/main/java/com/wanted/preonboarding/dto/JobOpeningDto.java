package com.wanted.preonboarding.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningDto {

    private long jobId;
    private long companyId;
    private String position;
    private int reward;
    private String content;
    private String skill;

}
