package christmas.model;

import static christmas.model.events.Events.CHAMPAGNE_EVENT;

import christmas.model.events.Events;
import christmas.model.events.DiscountEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppliedEvent {
    private final List<DiscountEvent> appliedEvent;
    private static final String GIVEAWAY_MENU = "샴페인 1개";

    private AppliedEvent(LocalDate date, Order order) {
        appliedEvent = Events.getAppliedEvents(date, order);
    }

    public static AppliedEvent getInstance(LocalDate date, Order order) {
        return new AppliedEvent(date, order);
    }

    public Map<String, Integer> getDiscountDetails(LocalDate date, Order order) {
        return appliedEvent.stream()
                .collect(Collectors.toMap(
                        DiscountEvent::getEventName, event -> event.getDiscountedMoney(date, order).toInt()
                ));
    }

    public String getGiveawayMenu() {
        return appliedEvent.stream()
                .filter(event -> event == CHAMPAGNE_EVENT)
                .findFirst()
                .map(event -> GIVEAWAY_MENU)
                .orElse(null);
    }

    public Money getTotalBenefitAmount(LocalDate date, Order order) {
        return appliedEvent.stream()
                .map(event -> event.getDiscountedMoney(date, order))
                .reduce(Money.ZERO, Money::plus);
    }
}
