package christmas.model.events.discount;

import christmas.model.Money;
import christmas.model.Order;
import christmas.model.food.MainDish;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidayDiscount extends DefaultDiscount {
    private static final Money DISCOUNT_UNIT = Money.valueOf(2023);

    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return DISCOUNT_UNIT.times(order.getCountMenuTypeOf(MainDish.class));
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }
}
