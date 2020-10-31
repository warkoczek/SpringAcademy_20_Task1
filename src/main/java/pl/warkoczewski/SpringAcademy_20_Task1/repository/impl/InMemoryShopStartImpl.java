package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.ShopStart;

import java.math.BigDecimal;



@Component
public class InMemoryShopStartImpl implements ShopStart {
    @Autowired
    private BasketImpl basket;

    public InMemoryShopStartImpl(BasketImpl basket) {
        this.basket = basket;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPrice() {
        double sum = basket.getProducts().stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
        BigDecimal sumBD = BigDecimal.valueOf(sum);
        System.out.println(sumBD);
    }



}
