package christmas.model.events;

import christmas.model.Money;

public interface DiscountEvent {
    String getEventName();

    Money getDiscountedMoney();
}
