package com.example.Spring.service;

import com.example.Spring.dto.SearchRequestDTO;
import com.example.Spring.dto.SearchResponseDTO;

public interface SearchService {
    SearchResponseDTO getProducts(SearchRequestDTO request);


}
