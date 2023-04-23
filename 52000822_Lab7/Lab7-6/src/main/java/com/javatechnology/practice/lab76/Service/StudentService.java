package com.javatechnology.practice.lab76.Service;

import com.javatechnology.practice.lab76.Module.Student;
import com.javatechnology.practice.lab76.Repository.PASRepository;
import com.javatechnology.practice.lab76.Repository.StudentRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface StudentService extends StudentRepository, PASRepository {
    //public Iterable<Student>
    Iterable<Student> findAllByAgeGreaterThanEqual(Integer x);
    Iterable<Student> findAllByIeltsScoreEquals(Double x);
    Iterable<Student> findByNameContainingIgnoreCase(String xx);
}
