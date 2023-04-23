package com.javatechnology.practice.lab74.Service;

import com.javatechnology.practice.lab74.Module.Student;
import com.javatechnology.practice.lab74.Repository.StudentRepository;

public interface StudentService extends StudentRepository {
    //public Iterable<Student>
    Iterable<Student> findAllByAgeGreaterThanEqual(Integer x);
    Iterable<Student> findAllByIeltsScoreEquals(Double x);
    Iterable<Student> findByNameContainingIgnoreCase(String xx);
}
