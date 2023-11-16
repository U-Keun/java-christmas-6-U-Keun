package christmas.model.events.discount;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasDDayDiscount extends DefaultDiscount {
    private static final Money DEFAULT_DISCOUNT_AMOUNT = Money.valueOf(1000);
    private static final Money ADDITIONAL_DISCOUNT_UNIT = Money.valueOf(100);
    private static final LocalDate FIRST_DAY_OF_DECEMBER = LocalDate.of(2023, 12, 1);
    private static final LocalDate CHRISTMAS = LocalDate.of(2023, 12, 25);

    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return DEFAULT_DISCOUNT_AMOUNT.plus(ADDITIONAL_DISCOUNT_UNIT.times(getPeriod(date)));
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        return !date.isBefore(FIRST_DAY_OF_DECEMBER) && !date.isAfter(CHRISTMAS);
    }

    private static long getPeriod(LocalDate date) {
        return ChronoUnit.DAYS.between(FIRST_DAY_OF_DECEMBER, date);
    }
}
