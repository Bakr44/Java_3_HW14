package com.example.assignment14.Controller;


import com.example.assignment14.ApiResponse.ApiResponse;
import com.example.assignment14.Model.Employees;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.SplittableRandom;

@RestController
@RequestMapping("/api/v1/employees")
public class ControllerEmployees {

    ArrayList<Employees> employees=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employees> getAllEmployees(){
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployees(@RequestBody @Valid Employees employee, Errors errors){

        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployees(@PathVariable int index,@RequestBody @Valid Employees employee,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index,employee);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployees(@PathVariable int index){
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
    }

    @GetMapping("/aplly/{id}")
    public ResponseEntity applyForLeave(@PathVariable String id){
        for (Employees employees1:employees) {
            if (employees1.getId().equalsIgnoreCase(id)){
                if (employees1.isOnLeave()){
                    return ResponseEntity.status(400).body(new ApiResponse("Employee is already on leave"));
                }
                if(employees1.getAnnualLeave()<=0){
                    return ResponseEntity.status(400).body(new ApiResponse("Employee has no leave days left"));
                }
                employees1.setOnLeave(true);
                employees1.setAnnualLeave(employees1.getAnnualLeave()-1);
                return ResponseEntity.status(200).body(employees1);
            }

        }return ResponseEntity.status(400).body(new ApiResponse("not Found"));

    }
}
