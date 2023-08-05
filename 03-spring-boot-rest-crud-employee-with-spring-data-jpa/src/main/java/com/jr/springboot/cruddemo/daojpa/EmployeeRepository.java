package com.jr.springboot.cruddemo.daojpa;

import com.jr.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // no need to write implementation class




}
