package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.ShopStart;

import java.math.BigDecimal;



@Component
public class ShopStartImpl implements ShopStart {

    private BasketImpl basket;
    @Autowired
    public ShopStartImpl(BasketImpl basket) {
        this.basket = basket;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPrice() {
        double doubleTotalNetPrice = basket.getProducts().stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
        BigDecimal bigDTotalNetPrice = BigDecimal.valueOf(doubleTotalNetPrice);
        System.out.println("Shop Start" + " " + bigDTotalNetPrice);
    }



}
