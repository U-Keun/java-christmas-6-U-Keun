package christmas.model.events.discount;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;

public class ChampagneDiscount extends DefaultDiscount {
    private static final Money DISCOUNT_CRITERIA = Money.valueOf(120000);
    private static final Money CHAMPAGNE_PRICE = Money.valueOf(25000);

    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return CHAMPAGNE_PRICE;
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        return order.getTotalOrderAmount().isGreaterThanOrEqual(DISCOUNT_CRITERIA);
    }
}
