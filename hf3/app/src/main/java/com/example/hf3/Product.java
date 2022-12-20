package com.example.hf3;

public class Product {
    String code;
    String name;
    Double price;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(String code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }


}
