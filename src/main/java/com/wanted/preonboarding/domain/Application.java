package com.wanted.preonboarding.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application extends DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId; // ID

    @ManyToOne(optional = false)
    @JoinColumn(name = "jobId")
    private JobOpening jobOpening; // 채용공고 ID

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user; // 지원자 ID

}
