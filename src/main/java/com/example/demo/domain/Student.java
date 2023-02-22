package com.example.demo.domain;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
}
