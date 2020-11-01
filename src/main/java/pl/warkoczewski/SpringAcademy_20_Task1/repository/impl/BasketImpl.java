package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;

import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.Basket;

import java.math.BigDecimal;
import java.util.ArrayList;
@Repository
public class BasketImpl implements Basket {
    private ArrayList<Product> productBasket;
    public BasketImpl() {
        productBasket = new ArrayList<>();
        productBasket.add(new Product("Milk", getRandomPrice(50, 300)));
        productBasket.add(new Product("Bread", getRandomPrice(50, 300)));
        productBasket.add(new Product("Cheese", getRandomPrice(50, 300)));
        productBasket.add(new Product("Beer", getRandomPrice(50, 300)));
        productBasket.add(new Product("Water", getRandomPrice(50, 300)));
    }

    @Override
    public ArrayList<Product> getProducts() {
        return productBasket;
    }

    @Override
    public void addProduct(Product product) {
        productBasket.add(product);
    }

    @Override
    public BigDecimal getTotalNetPrice() {
        double doubleTotalNetPrice = getProducts().stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
        BigDecimal bigDTotalNetPrice = BigDecimal.valueOf(doubleTotalNetPrice);
        return bigDTotalNetPrice;
    }

    private BigDecimal getRandomPrice(int lowest, int highest){
        return BigDecimal.valueOf(Math.random() * ((highest-lowest) +1) + lowest);

    }
}
