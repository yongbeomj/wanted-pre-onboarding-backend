package com.wanted.preonboarding.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
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

    protected User() {}

    private User(String password, String userName, String email) {
        this.password = password;
        this.userName = userName;
        this.email = email;
    }

    public static User of(String password, String userName, String email) {
        return new User(password, userName, email);
    }


}
