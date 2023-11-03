package com.employee.employeeapi.controller;

import com.employee.employeeapi.dto.EmployeeDTO;
import com.employee.employeeapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    //GET Request
    @RequestMapping("/employee")
    public List<EmployeeDTO> getAllEmpDetails(){
       return empService.getAllEmpData();
    }

    //POST Request
    @RequestMapping(method = RequestMethod.POST, value = "/employee")
    public void addEmployee(@RequestBody EmployeeDTO emp){
        empService.saveEmpData(emp);
    }

    //PUT Request
    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{empId}")
    public String updateEmployeeData(@RequestBody EmployeeDTO emp, @PathVariable("empId") Integer empId){
        return this.empService.updateEmployeeDetails(emp,empId);
    }

    //DELETE Request
    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{empId}")
    public String deleteEmployeeData(@PathVariable("empId") Integer empId)
    {
        return this.empService.deleteEmployeeData(empId);
    }
}
