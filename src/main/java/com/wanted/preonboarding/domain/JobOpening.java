package com.wanted.preonboarding.domain;

import com.wanted.preonboarding.dto.request.JobOpeningReqDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobOpening extends DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId; // ID

    @ManyToOne(optional = false)
    @JoinColumn(name = "companyId")
    private Company company; // 회사 ID

    private String position; // 채용 포지션
    private int reward; // 채용 보상금
    private String content; // 채용 내용
    private String skill; // 사용 기술

    // 채용공고 수정
    public void updateJobOpening(JobOpeningReqDto jobOpeningReqDto) {
        if (jobOpeningReqDto.getPosition() != null) { this.position = jobOpeningReqDto.getPosition(); }
        if (jobOpeningReqDto.getReward() > 0) { this.reward = jobOpeningReqDto.getReward(); }
        if (jobOpeningReqDto.getContent() != null) { this.content = jobOpeningReqDto.getContent(); }
        if (jobOpeningReqDto.getSkill() != null) { this.skill = jobOpeningReqDto.getSkill(); }
    }

}
