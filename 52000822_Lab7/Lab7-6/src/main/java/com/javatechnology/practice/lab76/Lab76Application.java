package com.javatechnology.practice.lab76;

import com.javatechnology.practice.lab76.Module.Student;
import com.javatechnology.practice.lab76.Service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab76Application implements CommandLineRunner {
    @Autowired
    StudentServiceImp studentServiceImp;

    public static void main(String[] args) {
        SpringApplication.run(Lab76Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentServiceImp.add(new Student(1L, "Le Van Viet1", 20, "vietvan05032002@gmail.com", 7.8));
        studentServiceImp.add(new Student(2L, "Le Van Viet2", 21, "vietvan05032002-1@gmail.com", 7.9));
        studentServiceImp.add(new Student(3L, "Le Van Viet3", 22, "vietvan05032002-2@gmail.com", 8.0));
        studentServiceImp.add(new Student(4L, "Le Van Viet4", 23, "vietvan05032002-3@gmail.com", 8.1));
        studentServiceImp.add(new Student(5L, "Le Van Viet5", 24, "vietvan05032002-4@gmail.com", 8.2));
        studentServiceImp.add(new Student(6L, "Le Van Viet6", 25, "vietvan05032002-5@gmail.com", 8.3));
        studentServiceImp.add(new Student(7L, "Nguyen Huynh Cam Thi", 22, "camthinguyenhuynh@gmail.com", 8.4));
        studentServiceImp.add(new Student(8L, "Nguyen Chi Tho1", 23, "chitho23-1@gmail.com", 7.8));
        studentServiceImp.add(new Student(9L, "Nguyen Chi Tho2", 24, "chitho23-2@gmail.com", 7.9));
        studentServiceImp.add(new Student(10L, "Nguyen Chi Tho3", 26, "chitho23-3@gmail.com", 8.5));
        studentServiceImp.update(new Student(1L, "Ze Zan Ziet", 21, "vietvan05032002@gmail.com", 8.0));
        studentServiceImp.Paging(0,5);
        studentServiceImp.SortByAsc();

    }
}
