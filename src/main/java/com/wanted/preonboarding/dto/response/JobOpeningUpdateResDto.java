package com.wanted.preonboarding.dto.response;

import com.wanted.preonboarding.domain.JobOpening;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningUpdateResDto {

    private long jobId;
    private String position;
    private int reward;
    private String content;
    private String skill;

    public static JobOpeningUpdateResDto toDto(JobOpening jobOpening) {
        return new JobOpeningUpdateResDto(
                jobOpening.getJobId(),
                jobOpening.getPosition(),
                jobOpening.getReward(),
                jobOpening.getContent(),
                jobOpening.getSkill()
        );
    }

}
