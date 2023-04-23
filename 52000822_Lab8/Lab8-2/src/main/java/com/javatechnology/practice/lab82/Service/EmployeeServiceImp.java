package com.javatechnology.practice.lab82.Service;


import com.javatechnology.practice.lab82.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmployeeService employeeService;

    public void addEmployee(Employee employee) {
        employeeService.save(employee);
    }

    public void removeEmployeeByID(Long id) {
        employeeService.deleteById(id);
    }

    public Iterable<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    public Object getOneEmployee(Long id) {
        return employeeService.findById(id);
    }
}
