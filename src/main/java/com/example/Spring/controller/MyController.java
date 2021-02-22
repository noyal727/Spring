package com.example.Spring.controller;

import com.example.Spring.dto.MyRequestDTO;
import com.example.Spring.dto.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping(path="/hello")
    public String helloWorld(){
        return "sucess";
    }
    @PostMapping(path = "/helloworld")
    public String Hellocoviam(){
        return "sucess";
    }
    @GetMapping(path="/hello-coviam")
    public String HelloWorld(@RequestParam String stat){
        return "Statement\t" + stat;
    }
    @PostMapping(path = "/register")
    public String registerUser(@RequestBody MyRequestDTO requestDTO){
        return requestDTO.toString();
    }
    @PostMapping(path = "/employee/{employee_Id}")
    public MyResponseDTO Edetails(@PathVariable String employee_Id){
        MyResponseDTO response=new MyResponseDTO();
        response.setId(employee_Id);
        return response;
    }

}
