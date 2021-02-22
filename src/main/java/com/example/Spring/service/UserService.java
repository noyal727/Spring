package com.example.Spring.service;

import com.example.Spring.dto.MyRequestDTO;
import com.example.Spring.dto.MyResponseDTO;

public interface UserService {
    boolean updateEmployee(MyRequestDTO request, String id);
}
