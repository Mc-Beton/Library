package com.library.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ACCDATE")
    private LocalDate accountDate;

    public User(String name, String surname, LocalDate accountDate) {
        this.name = name;
        this.surname = surname;
        this.accountDate = accountDate;
    }

    public User(Long id, String name, String surname, LocalDate accountDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accountDate = accountDate;
    }
}
