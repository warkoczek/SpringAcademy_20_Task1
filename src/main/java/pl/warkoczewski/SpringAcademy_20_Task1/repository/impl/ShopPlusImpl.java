package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Tax;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.ShopPlus;

import java.math.BigDecimal;
@Component
@Profile("PLUS")
public class ShopPlusImpl implements ShopPlus {

    private BasketImpl basket;
    private Tax tax;
    @Autowired
    public ShopPlusImpl(BasketImpl basket, Tax tax) {
        this.basket = basket;
        this.tax = tax;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalGrossPrice() {
        BigDecimal bigDTotalNetPrice = basket.getTotalNetPrice();
        BigDecimal totalGrossPrice = bigDTotalNetPrice.multiply(tax.getTaxValue()).add(bigDTotalNetPrice);
        System.out.println("Shop Plus" + " " + totalGrossPrice);
    }
}
