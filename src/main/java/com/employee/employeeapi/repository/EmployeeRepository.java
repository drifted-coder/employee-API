package com.employee.employeeapi.repository;

import com.employee.employeeapi.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
}
