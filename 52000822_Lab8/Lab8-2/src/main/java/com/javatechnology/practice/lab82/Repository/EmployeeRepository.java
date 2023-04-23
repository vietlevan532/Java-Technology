package com.javatechnology.practice.lab82.Repository;

import com.javatechnology.practice.lab82.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
