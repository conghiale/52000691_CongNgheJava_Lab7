package com.example.exercise3.service;

import com.example.exercise3.model.Student;
import com.example.exercise3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElse(null);
    }

    @Override
    public Student insertStudent(Student student) {
        if (student != null)
            return studentRepository.save(student);
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if (student != null) {
            if (getStudentById(student.getId()) != null) {
                studentRepository.delete(student);
                return studentRepository.existsById(student.getId());
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return studentRepository.existsById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        if (student != null) {
            Student student1 = getStudentById(id);
            student1.setName(student.getName());
            student1.setAge(student.getAge());
            student1.setEmail(student.getEmail());
            student1.setIelts(student.getIelts());
            return studentRepository.save(student1);
        }
        return null;
    }
}
