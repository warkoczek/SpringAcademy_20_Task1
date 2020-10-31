package pl.warkoczewski.SpringAcademy_20_Task1.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Getter
@Setter
public class Tax {
    @Value("${tax.taxValue}")
    private BigDecimal taxValue;
}
