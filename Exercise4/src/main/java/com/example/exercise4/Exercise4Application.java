package com.example.exercise4;

import com.example.exercise4.model.Student;
import com.example.exercise4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Exercise4Application implements CommandLineRunner {
    @Autowired
    private IStudentService studentService;
    private List<Student> students;
    public static void main(String[] args) {
        SpringApplication.run(Exercise4Application.class, args);
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

        students = this.studentService.findByAgeGreaterThanEqual(18);
        System.out.println("Students with age greater than or equal to 18: ");
        showStudents(students);

        System.out.println("The number of students with ielts score of 7.0 is: " + this.studentService.countStudentsWithIeltsScore(7.0));

        students = this.studentService.findByNameContaining("One");
        System.out.println("The students are found. Their information id: ");
        showStudents(students);
    }
    private void showStudents() {
        Iterable<Student> students = studentService.getStudentAll();
        students.forEach(System.out::println);
    }

    private void showStudents(List<Student> students) {
        students.forEach(System.out::println);
    }
}
