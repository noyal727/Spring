package com.example.Spring.dto;

public class SearchRequestDTO {
    private String searchTerm;

    public String getRequest() {
        return searchTerm;
    }

    public void setRequest(String request) {
        this.searchTerm = request;
    }
}
