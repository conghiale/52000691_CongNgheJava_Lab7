package com.example.exercise3;

import com.example.exercise3.model.Student;
import com.example.exercise3.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise3Application implements CommandLineRunner {
    @Autowired
    private IStudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Exercise3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("StudentOne", 18, "studentOne@gmail.com", 6.0);
        Student student2 = new Student("StudentTwo", 19, "studentTwo@gmail.com", 6.5);
        Student student3 = new Student("StudentThree", 20, "studentThree@gmail.com", 7.0);
        this.studentService.insertStudent(student1);
        this.studentService.insertStudent(student2);
        this.studentService.insertStudent(student3);
        showStudents();
        System.out.println("After update students");
        student1.setIelts(8.0);
        this.studentService.updateStudent(student1.getId(), student1);
        showStudents();
        System.out.println("After delete student");
        this.studentService.deleteStudentById(student1.getId());
        showStudents();
    }

    private void showStudents() {
        Iterable<Student> students = studentService.getStudentAll();
        students.forEach(System.out::println);
    }
}
