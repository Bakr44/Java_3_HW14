package com.example.assignment14.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employees {

    @NotEmpty(message = "should not be empty")
    @Size(min =2,message = "should be more than 2")
    private String id;

    @NotEmpty(message = "should not be empty")
    @Size(min = 4,message = "should be more than 4")
    private String name;

    @NotNull(message = "cant be null")
    @Min(25)
    private int age;

    @NotEmpty(message = "cant be empty")
    @Pattern(regexp = "supervisor|coordinator")
    private String position;

    @NotNull
    private boolean onLeave=false;

    @Positive(message = "invalid year")
    @NotNull(message = "employmentYear cannot be empty")
    @Digits(integer = 4, fraction = 0, message = "employmentYear must be a 4-digit number")
    private int employmentYear;

    @Positive(message = "annualLeave should not be null")
    @NotNull(message = "cant be empty")
    private int annualLeave;


}
