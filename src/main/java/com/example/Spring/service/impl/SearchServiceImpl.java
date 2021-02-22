package com.example.Spring.service.impl;

import com.example.Spring.client.SearchClient;
import com.example.Spring.dto.ProductDTO;
import com.example.Spring.dto.SearchRequestDTO;
import com.example.Spring.dto.SearchResponseDTO;
import com.example.Spring.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.*;

@Service

public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchClient searchClient;


    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {
        Map<String, Object> productResponce= searchClient.getProducts(request.getSearchTerm());
        List<Map<String, Object>> products = (List<Map<String, Object>>)((Map<String, Object>) productResponce.get("response")).get("docs");
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Map<String, Object> product: products) {
            // parse product into ProductDTO and add into productDTOS list
           String title= (String) product.get("name");
           ProductDTO p=new ProductDTO();
           p.setDescription((String) product.get("description"));
            p.setInstock((int) product.get("isInStock"));
            p.setSaleprice(Double.parseDouble(product.get("offerPrice").toString()));
           p.setTitle(title);
           productDTOS.add(p);

        }
        SearchResponseDTO responseDTO =new SearchResponseDTO();
        responseDTO.setProducts((productDTOS));
        return responseDTO;


    }
}
