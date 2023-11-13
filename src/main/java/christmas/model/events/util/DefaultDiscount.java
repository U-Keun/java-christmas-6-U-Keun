package christmas.model.events.util;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;

public abstract class DefaultDiscount implements DiscountHandler {
    private static final Money MINIMUM_AMOUNT_APPLICABLE_TO_EVENT = Money.valueOf(10000);

    @Override
    public Money getDiscountAmount(LocalDate date, Order order) {
        if (notEventApplicable(order)) {
            return Money.ZERO;
        }
        return calculateDiscountAmount(date, order);
    }

    private static boolean notEventApplicable(Order order) {
        return !order.getTotalOrderAmount().isGreaterThanOrEqual(MINIMUM_AMOUNT_APPLICABLE_TO_EVENT);
    }

    protected abstract Money calculateDiscountAmount(LocalDate date, Order order);
}
