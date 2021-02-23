package com.example.Spring.dto;

import java.util.List;

public class SearchResponseDTO {
    private List<ProductDTO> products;
    private List<ProductDTO> productLocation;


    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(List<ProductDTO> productLocation) {
        this.productLocation = productLocation;
    }
}
