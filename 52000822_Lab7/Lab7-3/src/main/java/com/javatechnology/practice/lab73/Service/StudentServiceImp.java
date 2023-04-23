package com.javatechnology.practice.lab73.Service;

import com.javatechnology.practice.lab73.Module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp {

    @Autowired
    public StudentService studentService;

    public void add(Student student) {
        studentService.save(student);
    }

    public void delete(Long id){
        studentService.deleteById(id);
    }

    public void update(Student student) {
        studentService.save(student);
    }

    public void showAll() {
        for (Student student: studentService.findAll()
             ) {
            System.out.println(student);
        }
    }
}
