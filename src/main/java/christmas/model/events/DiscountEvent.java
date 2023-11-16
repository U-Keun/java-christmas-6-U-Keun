package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;

public interface DiscountEvent {
    String getEventName();

    Money getDiscountedMoney(LocalDate date, Order order);
}
