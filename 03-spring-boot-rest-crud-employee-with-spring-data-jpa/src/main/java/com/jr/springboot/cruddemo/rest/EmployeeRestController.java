package com.jr.springboot.cruddemo.rest;

import com.jr.springboot.cruddemo.entity.Employee;
import com.jr.springboot.cruddemo.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceImpl employeeService;

    //quick: inject employee dao using constructor injection
    public EmployeeRestController(EmployeeServiceImpl theEmployeeServiceImpl){
        employeeService = theEmployeeServiceImpl;
    }
    //expose end point
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for Get /e/e id

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return theEmployee;

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

       return dbEmployee;

    }

    // add mapping for PUT/employees-update excisting employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //delete mapping
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("employee id not found "+ employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee Id - "+ employeeId;
    }

}










