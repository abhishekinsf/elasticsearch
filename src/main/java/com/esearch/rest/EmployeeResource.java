package com.esearch.rest;


import com.esearch.dbo.Employee;
import com.esearch.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author abhishek.k
 */
@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeResource.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee insert(@RequestBody Employee employee) {
        logger.info("Add Employee ");
        return employeeRepository.insert(employee);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEmployeeById(@PathVariable String id){
        logger.info("Get employee by id : {} ", id);
        return employeeRepository.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
        logger.info("Update employee by employee : {}", employee);
        return employeeRepository.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable String id) {
        logger.info("Delete employee by id : {} ", id);
        employeeRepository.deleteEmployeeById(id);
    }
}
