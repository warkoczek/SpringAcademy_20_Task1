package pl.warkoczewski.SpringAcademy_20_Task1.service;

import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;

public interface ShopPlusService {
    void addProduct(Product product);
    void getTotalPrice();
    void getTotalGrossPrice();

}
