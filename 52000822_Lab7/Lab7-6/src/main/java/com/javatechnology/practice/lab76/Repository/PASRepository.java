package com.javatechnology.practice.lab76.Repository;

import com.javatechnology.practice.lab76.Module.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PASRepository extends PagingAndSortingRepository<Student,Long> {
}
