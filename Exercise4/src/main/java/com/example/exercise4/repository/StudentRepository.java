package com.example.exercise4.repository;

import com.example.exercise4.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    public List<Student> findByAgeGreaterThanEqual(Integer age);
    public List<Student> findByIeltsEquals(double ieltsScore);
    public List<Student> findByNameContaining(String keyword);
}
