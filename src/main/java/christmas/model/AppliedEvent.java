package christmas.model;

import static christmas.model.events.DecemberEvent.CHAMPAGNE_EVENT;

import christmas.model.events.DecemberEvent;
import christmas.model.events.DiscountEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppliedEvent {
    private final List<DiscountEvent> appliedEvent;

    private AppliedEvent(LocalDate date, Order order) {
        appliedEvent = DecemberEvent.getAppliedEvents(date, order);
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

    public boolean hasGiveawayMenu() {
        return appliedEvent.stream()
                .anyMatch(event -> event == CHAMPAGNE_EVENT);
    }

    public Integer getTotalBenefitAmount(LocalDate date, Order order) {
        return (-1) * appliedEvent.stream()
                .mapToInt(event -> event.getDiscountedMoney(date, order).toInt())
                .sum();
    }
}
