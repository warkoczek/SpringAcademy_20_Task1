package pl.warkoczewski.SpringAcademy_20_Task1.repository;

import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;

public interface ProductBasket {

    void addProduct(Product product);
    void getTotalPrice();
}
