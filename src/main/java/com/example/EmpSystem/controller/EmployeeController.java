package com.example.EmpSystem.controller;

import com.example.EmpSystem.dto.EmployeeDTO;
import com.example.EmpSystem.models.response.DefaultResponse;
import com.example.EmpSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployee")
    public List<EmployeeDTO> getEmployee(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/saveEmployee")
    public DefaultResponse saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
       return employeeService.saveEmployee(employeeDTO);

    }

    @PutMapping("/updateEmployee")
    public DefaultResponse updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/deleteEmployee")
    public DefaultResponse deleteEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.deleteEmployee(employeeDTO);
    }
}
