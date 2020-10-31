package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Discount;
import pl.warkoczewski.SpringAcademy_20_Task1.domain.Tax;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.ShopPlus;
import pl.warkoczewski.SpringAcademy_20_Task1.repository.ShopPro;

import java.math.BigDecimal;

@Component
public class ShopProImpl implements ShopPro {


    private BasketImpl basket;
    private ShopPlusImpl shopPlus;
    private Discount discount;
    private Tax tax;
    @Autowired
    public ShopProImpl(BasketImpl basket, Discount discount, Tax tax, ShopPlusImpl shopPlus) {
        this.basket = basket;
        this.discount = discount;
        this.tax = tax;
        this.shopPlus = shopPlus;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getDiscountableTotalGrossPrice() {
        double doubleTotalNetPrice = basket.getProducts().stream().mapToDouble(product -> product.getPrice().doubleValue()).sum();
        BigDecimal bigDTotalNetPrice = BigDecimal.valueOf(doubleTotalNetPrice);
        BigDecimal discountableSum = bigDTotalNetPrice.subtract(bigDTotalNetPrice.multiply(discount.getDiscountValue()));
        BigDecimal discountableGrossSum = discountableSum.add(discountableSum.multiply(tax.getTaxValue()));
        System.out.println("Shop Pro" + " " + discountableGrossSum);
    }
}
