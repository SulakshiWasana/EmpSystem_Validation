package com.example.EmpSystem.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    @NotNull(message = "Id is required")
    private Integer id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Address is required")
    private String address;
    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email address")
    private String email;
}
