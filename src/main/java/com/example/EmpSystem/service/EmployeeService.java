package com.example.EmpSystem.service;

import com.example.EmpSystem.dto.EmployeeDTO;
import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.models.response.DefaultResponse;
import com.example.EmpSystem.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DefaultResponse saveEmployee(EmployeeDTO employeeDTO){
            Employee save = employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
            return new DefaultResponse("200", "Employee saved successfully!", save);
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return modelMapper.map(employeeList,new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    public DefaultResponse updateEmployee(EmployeeDTO employeeDTO){
        Employee update = employeeRepository.save(modelMapper.map(employeeDTO,Employee.class));
        return new DefaultResponse("200","Employee updated successfully !",update);
    }

    public DefaultResponse deleteEmployee(EmployeeDTO employeeDTO){
            employeeRepository.deleteById(employeeDTO.getId());
            return new DefaultResponse("200","Employee deleted successfully !");
    }

}
