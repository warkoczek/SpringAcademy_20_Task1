package pl.warkoczewski.SpringAcademy_20_Task1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.impl.BasketImpl;
import pl.warkoczewski.SpringAcademy_20_Task1.service.ShopStart;

import java.math.BigDecimal;



@Service
@Profile("START")
public class ShopStartImpl implements ShopStart {

    private BasketImpl basket;
    @Autowired
    public ShopStartImpl(BasketImpl basket) {
        this.basket = basket;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPrice() {
        BigDecimal bigDTotalNetPrice = basket.getTotalNetPrice();
        System.out.println("Shop Start" + " " + bigDTotalNetPrice);
    }



}
