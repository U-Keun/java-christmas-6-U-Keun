package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;

public interface DiscountHandler {
    boolean checkDiscountCondition(LocalDate date, Order order);

    Money getDiscountAmount(LocalDate date, Order order);
}
