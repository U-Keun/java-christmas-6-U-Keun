package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount extends DefaultDiscount {
    private static final LocalDate CHRISTMAS = LocalDate.of(2023, 12, 25);
    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return Money.valueOf(1000);
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        return date.equals(CHRISTMAS) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
