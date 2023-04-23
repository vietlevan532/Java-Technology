package com.javatechnology.practice.lab75;

import com.javatechnology.practice.lab75.Module.Student;
import com.javatechnology.practice.lab75.Service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab75Application implements CommandLineRunner {

    @Autowired
    StudentServiceImp studentServiceImp;

    public static void main(String[] args) {
        SpringApplication.run(Lab75Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");
        studentServiceImp.add(new Student(1L, "Le Van Viet", 21, "vietvan05032002@gmail.com", 7.8));
        studentServiceImp.add(new Student(2L, "Nguyen Huynh Cam Thi", 22, "camthinguyenhuynh@gmail.com", 7.8));
        studentServiceImp.add(new Student(3L, "Nguyen Chi Tho", 23, "chitho23@gmail.com", 7.8));
        studentServiceImp.update(new Student(1L, "Ze Zan Ziet", 21, "vietvan05032002@gmail.com", 8.0));
        System.out.println(studentServiceImp.studentService.findAgeGreaterThanEqual(22));
        System.out.println(studentServiceImp.studentService.findIeltsScoreEquals(8.0));
        System.out.println(studentServiceImp.studentService.findNameContainingIgnoreCase("Ziet"));
    }
}
