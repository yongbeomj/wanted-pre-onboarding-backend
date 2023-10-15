package com.wanted.preonboarding.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends DateField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // ID

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(nullable = false)
    private String userName; // 이름

    private String email; // 이메일

}
