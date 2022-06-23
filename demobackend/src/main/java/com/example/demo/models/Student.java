package com.example.demo.models;


import com.example.demo.enums.GenderEnum;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "students")
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String names;

    @NotNull
    private GenderEnum gender;

    @NotNull
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum age) {
        this.gender = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
