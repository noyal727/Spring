package com.example.Spring.controller;

import com.example.Spring.dto.ProductDTO;
import com.example.Spring.dto.SearchResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MyController {

    @PostMapping(path = "/searchemp")
    public String searchpd(@RequestBody ProductDTO requestDTO){

        return requestDTO.toString();
}

}
