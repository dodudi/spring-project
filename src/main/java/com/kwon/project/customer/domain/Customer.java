package com.kwon.project.customer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String username;
    private String password;
    private String profile;

    public Customer(Long id, String email, String username, String password, String profile) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public Customer(String email, String username, String password, String profile) {
        this(null, email, username, password, profile);
    }

    public void changeCustomer(String email, String username, String password, String profile) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }
}
