package pl.warkoczewski.SpringAcademy_20_Task1.repository;

import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface Cart {
    ArrayList<Product> getProducts();
    void addProduct(Product product);
    BigDecimal getTotalNetPrice();
}
