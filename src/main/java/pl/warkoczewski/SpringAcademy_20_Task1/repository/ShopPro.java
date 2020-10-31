package pl.warkoczewski.SpringAcademy_20_Task1.repository;

import java.math.BigDecimal;

public interface ShopPro {

    BigDecimal getDiscountableTotalGrossPrice(BigDecimal discount);
}
