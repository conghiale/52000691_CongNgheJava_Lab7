package com.example.exercise2.service;

import com.example.exercise2.model.Student;

import java.util.List;

public interface IStudentService {
    public Iterable<Student> getStudentAll();
    public Student getStudentById(int id);
    public Student insertStudent(Student student);
    public boolean deleteStudent(Student student);
    public boolean deleteStudentById(int id);
    public Student updateStudent(int id, Student student);
}
