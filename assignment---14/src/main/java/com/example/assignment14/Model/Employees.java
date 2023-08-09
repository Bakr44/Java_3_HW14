package com.example.assignment14.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employees {

    @NotEmpty(message = "ID should not be empty")
    @Size(min =2,message = "ID should be more than 2")
    private String id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4,message = "Name should be more than 4")
    private String name;

    @NotNull(message = "Age cant be null")
    @Min(value = 25,message = "Age should be more than 25")
    private int age;

    @NotEmpty(message = "Position cant be empty")
    @Pattern(regexp = "supervisor|coordinator",message = "Position should be supervisor OR coordinator")
    private String position;

    @NotNull(message = "OnLeave cannot be empty")
    @AssertFalse(message = "onLeave should be false")
    private boolean onLeave;

    @Positive(message = "invalid year")
    @NotNull(message = "employmentYear cannot be empty")
    @Digits(integer = 4, fraction = 0, message = "employmentYear must be a 4-digit number")
    private int employmentYear;

    @NotNull(message = "annualLeave cant be empty")
    @Min(0)
    private int annualLeave;


}
