package pl.warkoczewski.SpringAcademy_20_Task1.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Discount;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Product;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Tax;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.impl.BasketImpl;
import pl.warkoczewski.SpringAcademy_20_Task1.service.ShopProService;

import java.math.BigDecimal;

@Service
@Profile("PRO")
public class ShopProServiceImpl implements ShopProService {

    private BasketImpl basket;
    private Discount discount;
    private Tax tax;

    @Autowired
    public ShopProServiceImpl(BasketImpl basket, Discount discount, Tax tax) {
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
        System.out.println("Shop Pro - Start:" + " " + basket.getTotalNetPrice());;
    }

    @Override
    public void getTotalGrossPrice() {
        BigDecimal bigDTotalNetPrice = basket.getTotalNetPrice();
        BigDecimal totalGrossPrice = bigDTotalNetPrice.multiply(tax.getTaxValue()).add(bigDTotalNetPrice);
        System.out.println("Shop Pro - Plus" + " " + totalGrossPrice);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getDiscountableTotalGrossPrice() {
        double doubleTotalNetPrice = basket.getProducts().stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
        BigDecimal bigDTotalNetPrice = BigDecimal.valueOf(doubleTotalNetPrice);
        BigDecimal discountableSum = bigDTotalNetPrice.subtract(bigDTotalNetPrice.multiply(discount.getDiscountValue()));
        BigDecimal discountableGrossSum = discountableSum.add(discountableSum.multiply(tax.getTaxValue()));
        getTotalPrice();
        getTotalGrossPrice();
        System.out.println("Shop Pro Discountable Total Gross Price" + " " + discountableGrossSum);
    }
}
