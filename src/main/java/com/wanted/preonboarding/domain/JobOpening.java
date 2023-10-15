package com.wanted.preonboarding.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
public class JobOpening extends DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId; // ID

    @JoinColumn(name = "companyId")
    @ManyToOne(optional = false)
    private Company company; // 회사 ID

    @Column(nullable = false)
    private String position; // 채용 포지션

    @Column(nullable = false)
    private int reward; // 채용 보상금

    @Column(nullable = false, length = 10000)
    private String content; // 채용 내용

    private String skill; // 사용 기술

    protected JobOpening() {}

    private JobOpening(Company company, String position, int reward, String content, String skill) {
        this.company = company;
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.skill = skill;
    }

    public static JobOpening of(Company company, String position, int reward, String content, String skill) {
        return new JobOpening(company, position, reward, content, skill);
    }
}
