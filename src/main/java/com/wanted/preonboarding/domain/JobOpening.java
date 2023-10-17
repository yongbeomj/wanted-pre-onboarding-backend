package com.wanted.preonboarding.domain;

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

}
