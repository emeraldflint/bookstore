package com.bookstore.domain;

import javax.persistence.*;

/**
 * Created by z-dus on 12.03.2017.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;
    private String username;
    private String password;
    private String firtName;
    private String lastName;

    @Column(name="email", nullable = false, updatable = false)
    private String email;
    private String phone;
    private boolean enabled = true;
}
