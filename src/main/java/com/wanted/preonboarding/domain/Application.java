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
    private Long app_id; // ID

    @JoinColumn(name = "userId")
    @ManyToOne(optional = false)
    private User user; // 지원자 ID

    @JoinColumn(name = "jobId")
    @ManyToOne(optional = false)
    private JobOpening jobOpening; // 채용공고 ID

}
