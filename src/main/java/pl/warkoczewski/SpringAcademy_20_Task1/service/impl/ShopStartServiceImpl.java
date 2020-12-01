package pl.warkoczewski.SpringAcademy_20_Task1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.impl.CartImpl;
import pl.warkoczewski.SpringAcademy_20_Task1.service.ShopStartService;

import java.math.BigDecimal;

@Service
@Profile("START")
@Slf4j
public class ShopStartServiceImpl implements ShopStartService {

    private CartImpl basket;
    @Autowired
    public ShopStartServiceImpl(CartImpl basket) {
        this.basket = basket;
    }

    @Override
    public void addProduct(Product product) {
        basket.addProduct(product);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalPrice() {
        BigDecimal total = basket.getTotalNetPrice();
        log.debug("Shop Start(Net Price): {}", total );
    }
}
