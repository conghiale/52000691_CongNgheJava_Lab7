package com.example.exercise5.repository;

import com.example.exercise5.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryPageAndSort extends PagingAndSortingRepository<Student, Integer> {
}
