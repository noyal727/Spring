package com.example.Spring.service.impl;

import com.example.Spring.dto.MyRequestDTO;
import com.example.Spring.dto.MyResponseDTO;
import com.example.Spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("inside userservice constructor");
    }
    @PostConstruct
    public void init(){
        System.out.println("inside userservice post constructor");
    }

    @Override

    public boolean updateEmployee(MyRequestDTO request, String id) {
        System.out.println("inside user service"+request+"id");
        return false;
    }
}
