package com.example.exercise5;

import com.example.exercise5.model.Student;
import com.example.exercise5.model.StudentPage;
import com.example.exercise5.repository.StudentRepository;
import com.example.exercise5.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootApplication
public class Exercise5Application implements CommandLineRunner {

    @Autowired
    private IStudentService studentService;
    private Page<Student> page;
    private StudentPage studentPage = new StudentPage();
    public static void main(String[] args) {
        SpringApplication.run(Exercise5Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if (studentSize() != 0) {
            this.studentService.deleteAll();
        }
        Student student1 = new Student(1, "StudentOne", 18, "studentOne@gmail.com", 6.0);
        Student student2 = new Student(2,"StudentTwo", 19, "studentTwo@gmail.com", 6.5);
        Student student3 = new Student(3,"StudentThree", 20, "studentThree@gmail.com", 7.0);
        Student student4 = new Student(4,"StudentFour", 19, "studentFour@gmail.com", 7.2);
        Student student5 = new Student(5,"StudentFive", 25, "studentFive@gmail.com", 5.0);
        Student student6 = new Student(6,"StudentSix", 21, "studentSix@gmail.com", 6.0);
        Student student7 = new Student(7,"StudentSeven", 20, "studentSeven@gmail.com", 6.8);
        Student student8 = new Student(8,"StudentEight", 20, "studentEight@gmail.com", 7.0);
        Student student9 = new Student(9,"StudentNine", 20, "studentNine@gmail.com", 8.0);
        Student student10 = new Student(10,"StudentTen", 20, "studentTen@gmail.com", 8.5);
        this.studentService.insertStudent(student1);
        this.studentService.insertStudent(student2);
        this.studentService.insertStudent(student3);
        this.studentService.insertStudent(student4);
        this.studentService.insertStudent(student5);
        this.studentService.insertStudent(student6);
        this.studentService.insertStudent(student7);
        this.studentService.insertStudent(student8);
        this.studentService.insertStudent(student9);
        this.studentService.insertStudent(student10);
        showStudents();

        System.out.println();
        System.out.println("Students with descending order by age and ascending order according to ielts scores.: ");
        studentPage.setPageNumber(0);
        studentPage.setPageSize(studentSize());
        Page<Student> page = this.studentService.getStudentsByAgeDescIeltsAsc(studentPage);
        showStudents(page);

        System.out.println();
        System.out.println("Students 4-5-6.: ");
        page = this.studentService.getStudent456();
        showStudents(page);
    }
    private void showStudents() {
        Iterable<Student> students = studentService.getStudentAll();
        students.forEach(System.out::println);
    }

    private void showStudents(Page<Student> students) {
        students.getContent().forEach(System.out::println);
    }

    private int studentSize() {
        Iterable<Student> students = studentService.getStudentAll();
        int count = 0;
        for (Student s : students) {
            count++;
        }
        return count;
    }
}
