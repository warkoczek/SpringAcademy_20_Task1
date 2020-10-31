package pl.warkoczewski.SpringAcademy_20_Task1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Tax;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.impl.BasketImpl;
import pl.warkoczewski.SpringAcademy_20_Task1.service.ShopPlusService;

import java.math.BigDecimal;
@Service
@Profile("PLUS")
public class ShopPlusServiceImpl implements ShopPlusService {

    private BasketImpl basket;
    private Tax tax;
    @Autowired
    public ShopPlusServiceImpl(BasketImpl basket, Tax tax) {
        this.basket = basket;
        this.tax = tax;
    }

    @Override
    public void addProduct(Product product) {
        basket.addProduct(product);
    }

    @Override
    public void getTotalPrice() {
        System.out.println("Shop Plus - Start:" + " " + basket.getTotalNetPrice());;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getTotalGrossPrice() {
        BigDecimal bigDTotalNetPrice = basket.getTotalNetPrice();
        BigDecimal totalGrossPrice = bigDTotalNetPrice.multiply(tax.getTaxValue()).add(bigDTotalNetPrice);
        getTotalPrice();
        System.out.println("Shop Plus Taxable:" + " " + totalGrossPrice);
    }
}
