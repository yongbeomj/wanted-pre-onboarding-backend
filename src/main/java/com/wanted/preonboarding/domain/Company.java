package com.wanted.preonboarding.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company extends DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId; // ID

    @Column(nullable = false)
    private String companyName; // 회사명

    private String country; // 회사 소재 국가
    private String region; // 회사 소재 지역

}
