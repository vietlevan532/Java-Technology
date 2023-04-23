package com.javatechnology.practice.lab75.Service;

import com.javatechnology.practice.lab75.Module.Student;
import com.javatechnology.practice.lab75.Repository.StudentRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentService extends StudentRepository {

    //Tim sinh tuoi lon hon hoac bang x
    @Query("SELECT a FROM student a WHERE a.age >= :x")
    Iterable<Student> findAgeGreaterThanEqual(Integer x);

    //Tim diem Ielts bang x
    @Query("SELECT iS FROM student iS WHERE iS.ieltsScore = :x")
    Iterable<Student> findIeltsScoreEquals(Double x);

    //Tim ten co chua tu xxx
    @Query("SELECT ci FROM student ci WHERE ci.name LIKE %:nameE%")
    Iterable<Student> findNameContainingIgnoreCase(String nameE);
}
