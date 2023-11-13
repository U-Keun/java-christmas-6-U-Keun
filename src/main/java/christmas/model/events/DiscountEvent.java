package christmas.model.events;

import christmas.model.Order;
import java.time.LocalDate;
import java.util.List;

public interface DiscountEvent {
    List<DiscountEvent> getAppliedEvents(LocalDate date, Order order);
}
