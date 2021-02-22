package com.example.Spring.service.impl;

import com.example.Spring.dto.ProductDTO;
import com.example.Spring.dto.SearchRequestDTO;
import com.example.Spring.dto.SearchResponseDTO;
import com.example.Spring.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service

public class SearchServiceImpl implements SearchService {
    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {
        SearchResponseDTO responseDTO =new SearchResponseDTO();
        ProductDTO product=new ProductDTO();
        product.setDescription("iphone 11 pro ...");
        product.setTitle("iphone");
        product.setInstock(true);
        product.setSaleprice("10000");
        responseDTO.setProducts(Arrays.asList(product));
        return responseDTO;


    }
}
