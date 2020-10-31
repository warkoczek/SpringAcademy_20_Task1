package pl.warkoczewski.SpringAcademy_20_Task1.repository;

import java.math.BigDecimal;

public interface ShopPlus {

    BigDecimal getTotalGrossPrice(BigDecimal tax);

}
