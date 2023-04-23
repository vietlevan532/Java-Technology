package com.javatechnology.practice.lab82;

import com.javatechnology.practice.lab82.Model.Employee;
import com.javatechnology.practice.lab82.Service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab82Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lab82Application.class, args);
    }

    @Autowired
    private EmployeeServiceImp employeeServiceImp;
    @Override
    public void run(String... args) throws Exception {
        employeeServiceImp.addEmployee(new Employee(1L, "Le Van Viet", "vietvan05032002@gmail.com", "20050301"));
        employeeServiceImp.addEmployee(new Employee(2L, "Nguyen Huynh Cam Thi", "camthi2301@gmail.com", "19070302"));
        employeeServiceImp.addEmployee(new Employee(3L, "Dau Dau Map", "daumapdit2022@gmail.com", "20050301H"));
        System.out.println(employeeServiceImp.getAllEmployee());
        System.out.println(employeeServiceImp.getOneEmployee(3L));
    }
}
