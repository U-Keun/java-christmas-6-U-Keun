package christmas.model.events.util;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;

public class ChampagneDiscount extends DefaultDiscount {
    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return Money.valueOf(25000);
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        return order.getTotalOrderAmount().isGreaterThanOrEqual(Money.valueOf(120000));
    }
}
