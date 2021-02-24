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
import java.util.concurrent.*;

import static java.util.Arrays.*;

@Service

public class SearchServiceImpl implements SearchService {
    public void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    @Autowired
    private SearchClient searchClient;


    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {
        SearchResponseDTO responseDTO = new SearchResponseDTO();


        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable runnableTask1 = () -> {
            Map<String, Object> productResponce = searchClient.getProducts(request.getSearchTerm());
            List<Map<String, Object>> products = (List<Map<String, Object>>) ((Map<String, Object>) productResponce.get("response")).get("docs");
            List<ProductDTO> list = new ArrayList<>();

            for (Map<String, Object> product : products) {
                // parse product into ProductDTO and add into productDTOS list
                String title = (String) product.get("name");
                ProductDTO p = new ProductDTO();

                p.setDescription((String) product.get("description"));
                p.setInstock((int) product.get("isInStock") == 1 ? true : false);
                //p.setSaleprice(Double.parseDouble(product.get("offerPrice").toString()));
                p.setTitle(title);
                list.add(p);

            }
            responseDTO.setProducts((list));
        };
        Runnable runnableTask2 = () -> {
            Map<String, Object> plocation = searchClient.getProducts("stockLocation:" + "\"" + request.getLocation() + "\"");
            List<Map<String, Object>> locationlist = (List<Map<String, Object>>) ((Map<String, Object>) plocation.get("response")).get("docs");
            List<ProductDTO> list1 = new ArrayList<>();
            for (Map<String, Object> product : locationlist) {
                // parse product into ProductDTO and add into productDTOS list
                String title = (String) product.get("name");
                ProductDTO p = new ProductDTO();

                p.setDescription((String) product.get("description"));
                p.setInstock((int) product.get("isInStock") == 1 ? true : false);
                //p.setSaleprice(Double.parseDouble(product.get("offerPrice").toString()));
                p.setTitle(title);
                list1.add(p);
            }
            responseDTO.setProductLocation((list1));
        };

        executor.execute(runnableTask1);
        executor.execute(runnableTask2);
        awaitTerminationAfterShutdown(executor);

            return responseDTO;


        }
    }
