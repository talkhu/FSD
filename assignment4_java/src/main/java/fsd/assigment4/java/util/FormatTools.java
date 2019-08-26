package fsd.assigment4.java.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FormatTools {
    public double formatMoney(BigDecimal money) {
        money = money.setScale(2, RoundingMode.HALF_UP);
        return money.doubleValue();
    };
}
