package com.wanted.preonboarding.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
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

    protected Application() {}

    private Application(User user, JobOpening jobOpening) {
        this.user = user;
        this.jobOpening = jobOpening;
    }

    public static Application of(User user, JobOpening jobOpening) {
        return new Application(user, jobOpening);
    }
}
