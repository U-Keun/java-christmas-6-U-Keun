package christmas.model;

import christmas.model.events.DecemberEvent;
import christmas.model.events.DiscountEvent;
import java.time.LocalDate;
import java.util.List;

public class Reservation {
    private final LocalDate date;
    private final Order order;
    private final List<DiscountEvent> eventList;
    private static final Integer THIS_YEAR = 2023;
    private static final Integer THIS_MONTH = 12;

    private Reservation(Integer dayNumber, Order order) {
        this.date = LocalDate.of(THIS_YEAR, THIS_MONTH, dayNumber);
        this.order = order;
        this.eventList = DecemberEvent.getAppliedEvents(date, order);
    }
}
