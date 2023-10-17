package com.wanted.preonboarding.domain;

import com.wanted.preonboarding.dto.JobOpeningDto;
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
    public void updateJobOpening(JobOpeningDto jobOpeningDto) {
        if (jobOpeningDto.getPosition() != null) { this.position = jobOpeningDto.getPosition(); }
        if (jobOpeningDto.getReward() > 0) { this.reward = jobOpeningDto.getReward(); }
        if (jobOpeningDto.getContent() != null) { this.content = jobOpeningDto.getContent(); }
        if (jobOpeningDto.getSkill() != null) { this.skill = jobOpeningDto.getSkill(); }
    }

}
