package com.javatechnology.practice.lab82.Controller;

import com.javatechnology.practice.lab82.Model.Employee;
import com.javatechnology.practice.lab82.Service.EmployeeServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeServiceImp employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Employee> employeeList = (List<Employee>) employeeService.getAllEmployee();
        model.addAttribute("employees", employeeList);
        return "index";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.GET)
    public String addEmp(){
        return "add";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public RedirectView add(HttpServletRequest httpRequest){
        Employee employee = new Employee(httpRequest.getParameter("name"), httpRequest.getParameter("email"), httpRequest.getParameter("classCode"));
        employeeService.addEmployee(employee);
        return new RedirectView("/employees");
    }

    @RequestMapping(value = "/employees/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "id") Long id){
        Object employee = employeeService.getOneEmployee(id);
        Employee employee1 = (Employee)employee;
        model.addAttribute("employee", employee1);
        return "edit";
    }

    @RequestMapping(value = "/employees/edit/{id}", method = RequestMethod.POST)
    public RedirectView update(HttpServletRequest httpRequest, @PathVariable("id") Long id){
        Object employee = employeeService.getOneEmployee(id);
        Employee employee1 = (Employee) employee;
        employee1.setName(httpRequest.getParameter("name"));
        employee1.setEmail(httpRequest.getParameter("email"));
        employee1.setClassCode(httpRequest.getParameter("classCode"));
        employeeService.addEmployee(employee1);
        return new RedirectView("/employees");
    }

    @RequestMapping(value = "/employees/delete/{id}", method = RequestMethod.POST)
    public RedirectView deleteEmp(@PathVariable("id") Long id) {
        employeeService.removeEmployeeByID(id);
        return new RedirectView("/employees");
    }
}
