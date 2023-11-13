package christmas.model.events.util;

import christmas.model.Money;
import christmas.model.Order;
import christmas.model.food.Dessert;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscount extends DefaultDiscount {
    @Override
    protected Money calculateDiscountAmount(LocalDate date, Order order) {
        if (checkDiscountCondition(date, order)) {
            return Money.valueOf(2023).times(order.getCountMenuTypeOf(Dessert.class));
        }
        return Money.ZERO;
    }

    @Override
    public boolean checkDiscountCondition(LocalDate date, Order order) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return !(dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY));
    }
}
