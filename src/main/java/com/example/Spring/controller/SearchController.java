package com.example.Spring.controller;

import com.example.Spring.dto.SearchRequestDTO;
import com.example.Spring.dto.SearchResponseDTO;
import com.example.Spring.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
@Autowired
    private SearchService searchService;
    @PostMapping(path="/search")
    public SearchResponseDTO getProduct(@RequestBody SearchRequestDTO request){
        return searchService.getProducts(request);
    }
}
