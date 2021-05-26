package com.spring.reactive.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuperHero implements Serializable {

    @Id
    private int id;

    private String name;
    private String superName;
    private String profession;
    private int age;
    private boolean canFly;

    // Constructor, Getter and Setter
}