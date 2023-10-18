package com.wanted.preonboarding.dto.response;

import com.wanted.preonboarding.domain.JobOpening;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobOpeningDtlResDto {

    private long jobId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private int reward;
    private String skill;
    private String content;
    private List<String> otherJobIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static JobOpeningDtlResDto toDto(JobOpening jobOpening, List<String> jobIds) {
        return new JobOpeningDtlResDto(
                jobOpening.getJobId(),
                jobOpening.getCompany().getCompanyName(),
                jobOpening.getCompany().getCountry(),
                jobOpening.getCompany().getRegion(),
                jobOpening.getPosition(),
                jobOpening.getReward(),
                jobOpening.getSkill(),
                jobOpening.getContent(),
                jobIds,
                jobOpening.getCreatedAt(),
                jobOpening.getUpdatedAt()
        );
    }

}
