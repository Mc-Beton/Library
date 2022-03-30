package com.library.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String title;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ACCDATE")
    private LocalDate accountDate;
}
