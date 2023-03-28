package com.example.exercise5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @Setter @Getter
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private double ielts;

    public Student(String name, int age, String email, double ielts) {
        super();
        this.name = name;
        this.age = age;
        this.email = email;
        this.ielts = ielts;
    }

    public Student(int id, String name, int age, String email, double ielts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.ielts = ielts;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", ielts=" + ielts +
                '}';
    }
}
