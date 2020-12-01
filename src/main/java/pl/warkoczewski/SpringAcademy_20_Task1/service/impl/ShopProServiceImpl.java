package pl.warkoczewski.SpringAcademy_20_Task1.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Discount;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Tax;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.impl.CartImpl;
import pl.warkoczewski.SpringAcademy_20_Task1.service.ShopProService;

import java.math.BigDecimal;

@Service
@Profile("PRO")
@Slf4j
public class ShopProServiceImpl implements ShopProService {

    private CartImpl basket;
    private Discount discount;
    private Tax tax;

    @Autowired
    public ShopProServiceImpl(CartImpl basket, Discount discount, Tax tax) {
        this.basket = basket;
        this.discount = discount;
        this.tax = tax;
    }

    @Override
    public void addProduct(Product product) {
        basket.getTotalNetPrice();
    }

    @Override
    public void getTotalPrice() {
        log.debug("Shop Pro - Start(Net Price): {}",basket.getTotalNetPrice());
    }

    @Override
    public void getTotalGrossPrice() {
        BigDecimal bigDTotalNetPrice = basket.getTotalNetPrice();
        BigDecimal totalGrossPrice = bigDTotalNetPrice.multiply(tax.getTaxValue()).add(bigDTotalNetPrice);
        log.debug("Shop Pro - Plus(Gross Price): {}",totalGrossPrice);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getDiscountableTotalGrossPrice() {
        BigDecimal bigDTotalNetPrice = basket.getTotalNetPrice();
        BigDecimal discountableTotalNetPrice = bigDTotalNetPrice.subtract(bigDTotalNetPrice.multiply(discount.getDiscountValue()));
        BigDecimal discountableTotalGrossPrice = discountableTotalNetPrice.add(discountableTotalNetPrice.multiply(tax.getTaxValue()));
        getTotalPrice();
        getTotalGrossPrice();
        log.debug("Shop Pro - Pro(Discount Price): {}", discountableTotalGrossPrice);
    }
}
