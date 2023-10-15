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

}
