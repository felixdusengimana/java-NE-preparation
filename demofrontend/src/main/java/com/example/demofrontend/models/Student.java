package com.example.demofrontend.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Long id;
    private String names;
    private String gender;
    private String email;
}
