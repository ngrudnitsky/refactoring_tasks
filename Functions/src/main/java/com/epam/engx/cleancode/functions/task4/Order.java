package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.List;

public class Order {
    private List<Product> products;

    public Double getPriceOfAvailableProducts() {
        double orderPrice = 0.0;
        for (Product product : products) {
            if (product.isAvailable()) {
                orderPrice += product.getProductPrice();
            }
        }
        return orderPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
