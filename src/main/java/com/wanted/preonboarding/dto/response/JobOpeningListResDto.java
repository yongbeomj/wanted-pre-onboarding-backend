package com.wanted.preonboarding.dto.response;

import com.wanted.preonboarding.domain.JobOpening;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningListResDto {

    private long jobId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private int reward;
    private String skill;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static JobOpeningListResDto toDto(JobOpening jobOpening) {
        return new JobOpeningListResDto(
                jobOpening.getJobId(),
                jobOpening.getCompany().getCompanyName(),
                jobOpening.getCompany().getCountry(),
                jobOpening.getCompany().getRegion(),
                jobOpening.getPosition(),
                jobOpening.getReward(),
                jobOpening.getSkill(),
                jobOpening.getCreatedAt(),
                jobOpening.getUpdatedAt()
        );
    }

}
