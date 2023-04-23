package com.javatechnology.practice.lab76.Service;

import com.javatechnology.practice.lab76.Module.Student;
import com.javatechnology.practice.lab76.Repository.PASRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp {

    @Autowired
    public StudentService studentService;
    @Autowired
    public PASRepository pasRepository;

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

    public void Paging(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo,pageSize);
        Page<Student> pageStudent = pasRepository.findAll(paging);
        System.out.println(pageStudent);
    }

    public List<Student> SortByAsc() {
        Sort sortOderByAge = Sort.by("age").ascending();
        Sort sortOderByIeltsScore = Sort.by("ieltsScore").ascending();
        Sort groupBySort = sortOderByAge.and(sortOderByIeltsScore);
        return (List<Student>) pasRepository.findAll(groupBySort);
    }




}
