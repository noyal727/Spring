package com.example.Spring.dto;

public class ProductDTO {
    private int instock;
    private Double saleprice;
    private String description;
    private String title;

    public int isInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public Double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Double saleprice) {
        this.saleprice = saleprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MyRequestDTO{" +
                "instock=" + instock +
                ", saleprice='" + saleprice + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

