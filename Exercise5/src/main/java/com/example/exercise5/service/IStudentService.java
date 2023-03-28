package com.example.exercise5.service;

import com.example.exercise5.model.Student;
import com.example.exercise5.model.StudentPage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudentService {
    public Iterable<Student> getStudentAll();
    public Student getStudentById(int id);
    public Student insertStudent(Student student);
    public boolean deleteStudent(Student student);
    public boolean deleteStudentById(int id);
    public void deleteAll();
    public Student updateStudent(int id, Student student);

    public Page<Student> getStudentsByAgeDescIeltsAsc(StudentPage studentPage);
    public Page<Student>getStudent456();
}
