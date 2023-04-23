package com.javatechnology.practice.lab76.Repository;

import com.javatechnology.practice.lab76.Module.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
