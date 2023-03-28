package com.example.exercise4.service;

import com.example.exercise4.model.Student;

import java.util.List;

public interface IStudentService {
    public Iterable<Student> getStudentAll();
    public Student getStudentById(int id);
    public Student insertStudent(Student student);
    public boolean deleteStudent(Student student);
    public boolean deleteStudentById(int id);
    public Student updateStudent(int id, Student student);
    public List<Student> findByAgeGreaterThanEqual(int age);

    public int countStudentsWithIeltsScore(double ielts);

    public List<Student> findByNameContaining(String keyword);

}
