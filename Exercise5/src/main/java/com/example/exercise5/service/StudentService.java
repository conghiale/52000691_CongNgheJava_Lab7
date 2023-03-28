package com.example.exercise5.service;

import com.example.exercise5.model.Student;
import com.example.exercise5.model.StudentPage;
import com.example.exercise5.repository.StudentRepository;
import com.example.exercise5.repository.StudentRepositoryPageAndSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRepositoryPageAndSort studentRepositoryPageAndSort;

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

    @Override
    public void deleteAll() {
        this.studentRepository.deleteAll();
    }

    @Override
    public Page<Student> getStudentsByAgeDescIeltsAsc(StudentPage studentPage) {
        Sort sort = Sort.by(studentPage.getSortDirectionAge(), studentPage.getSortByAge())
                .and(Sort.by(studentPage.getSortDirectionIelts(), studentPage.getSortByIelts()));
        Pageable pageable = PageRequest.of(studentPage.getPageNumber(), studentPage.getPageSize(), sort);
        return studentRepositoryPageAndSort.findAll(pageable);
    }

    @Override
    public Page<Student> getStudent456() {
        Pageable pageable = PageRequest.of(1, 3);
        return studentRepositoryPageAndSort.findAll(pageable);
    }

}
