package com.javatechnology.practice.lab72;

import com.javatechnology.practice.lab72.Module.Student;
import com.javatechnology.practice.lab72.Service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab72Application implements CommandLineRunner {
    @Autowired
    private StudentServiceImp studentServiceImp;

    public static void main(String[] args) {
        SpringApplication.run(Lab72Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentServiceImp.add(new Student(1L, "Le Van Viet", 21, "vietvan05032002@gmail.com", 7.8));
        studentServiceImp.add(new Student(2L, "Nguyen Huynh Cam Thi", 22, "camthinguyenhuynh@gmail.com", 7.8));
        studentServiceImp.add(new Student(3L, "Nguyen Chi Tho", 23, "chitho23@gmail.com", 7.8));
        studentServiceImp.delete(3L);
        studentServiceImp.update(new Student(1L, "Ze Zan Ziet", 21, "vietvan05032002@gmail.com", 8.0));
        studentServiceImp.showAll();
    }
}
