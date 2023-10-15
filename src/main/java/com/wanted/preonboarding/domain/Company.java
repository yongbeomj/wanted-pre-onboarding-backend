package com.wanted.preonboarding.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
public class Company extends DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId; // ID

    @Column(nullable = false)
    private String companyName; // 회사명

    private String country; // 회사 소재 국가

    private String region; // 회사 소재 지역

    protected Company() {}

    private Company(String companyName, String country, String region) {
        this.companyName = companyName;
        this.country = country;
        this.region = region;
    }

    public static Company of(String companyName, String country, String region) {
        return new Company(companyName, country, region);
    }

}
