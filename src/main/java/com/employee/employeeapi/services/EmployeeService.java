package com.employee.employeeapi.services;

import com.employee.employeeapi.dto.EmployeeDTO;
import com.employee.employeeapi.models.Employee;
import com.employee.employeeapi.repository.EmployeeRepository;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepository;

    public List<EmployeeDTO> getAllEmpData() {
        List<Employee> empData = new ArrayList<>();
        empRepository.findAll().forEach(empData::add);

        log.info("Data returned successfully");
        return empData.stream().map(this::mapToEmployeeDTO).toList();
    }

    private EmployeeDTO mapToEmployeeDTO(Employee emp) {
        return EmployeeDTO.builder().id(emp.getId()).name(emp.getName()).mobNumber(emp.getMobNumber()).address(emp.getAddress()).build();
    }

    // save employee data
    public void saveEmpData(EmployeeDTO emp) {
        Employee employee = Employee.builder().id(emp.getId()).name(emp.getName()).mobNumber(emp.getMobNumber()).address(emp.getAddress()).build();
        empRepository.save(employee);

        log.info("Employee with {} is created",employee.getId());
    }

    //update employee data
    public String updateEmployeeDetails(EmployeeDTO emp, Integer empId) {
        Employee employee = Employee.builder().id(emp.getId()).name(emp.getName()).mobNumber(emp.getMobNumber()).address(emp.getAddress()).build();
        this.empRepository.save(employee);
        log.info("Updated Successfully");

        return "Updated Successfully";
    }

    // delete employee data
    public String deleteEmployeeData(Integer empId) {
        this.empRepository.deleteById(empId);
        log.info("Deleted Successfully");

        return "Deleted Successfully";
    }
}
