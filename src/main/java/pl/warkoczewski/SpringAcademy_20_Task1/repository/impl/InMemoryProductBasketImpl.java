package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.ProductBasket;
import java.util.ArrayList;


@Component
public class InMemoryProductBasketImpl implements ProductBasket {

    private final ArrayList<Product> productBasket;

    public InMemoryProductBasketImpl() {
        productBasket = new ArrayList<>();
        productBasket.add(new Product("Milk", getRandomPrice(50, 300)));
        productBasket.add(new Product("Bread", getRandomPrice(50, 300)));
        productBasket.add(new Product("Cheese", getRandomPrice(50, 300)));
        productBasket.add(new Product("Beer", getRandomPrice(50, 300)));
        productBasket.add(new Product("Water", getRandomPrice(50, 300)));

    }

    @Override
    public void addProduct(Product product) {
        productBasket.add(product);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPrice() {
        Double sum = productBasket.stream().mapToDouble(product -> product.getPrice()).sum();
        System.out.println(sum);
    }

    private double getRandomPrice(int lowest, int highest){
        return Math.random() * ((highest-lowest) +1) + lowest;

    }

}
