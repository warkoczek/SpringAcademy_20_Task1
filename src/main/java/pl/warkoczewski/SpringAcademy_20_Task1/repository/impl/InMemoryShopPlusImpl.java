package pl.warkoczewski.SpringAcademy_20_Task1.repository.impl;

import pl.warkoczewski.SpringAcademy_20_Task1.repository.ShopPlus;

import java.math.BigDecimal;

public class InMemoryShopPlusImpl implements ShopPlus {

    private InMemoryShopStartImpl basketStart;
    @Override
    public BigDecimal getTotalGrossPrice(BigDecimal tax) {

        return null;
    }
}
