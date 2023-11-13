package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasDDayDiscount extends DefaultDiscount {
    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return Money.valueOf(1000).plus(Money.valueOf(100).times(getPeriod(date)));
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        LocalDate startDay = LocalDate.of(2023, 12, 1);
        LocalDate endDay = LocalDate.of(2023, 12, 25);
        return !date.isBefore(startDay) && !date.isAfter(endDay);
    }

    private static long getPeriod(LocalDate date) {
        return ChronoUnit.DAYS.between(LocalDate.of(2023, 12, 1), date);
    }
}
