package christmas.model;

import christmas.model.events.DecemberEvent;
import christmas.model.events.DiscountEvent;
import christmas.model.events.util.ChampagneDiscount;
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

    public Map<String, Integer> getDiscountDetails() {
        return appliedEvent.stream()
                .collect(Collectors.toMap(
                        DiscountEvent::getEventName, event -> event.getDiscountedMoney().toInt()
                ));
    }

    public boolean hasGiveawayMenu() {
        return appliedEvent.stream()
                .anyMatch(event -> event instanceof ChampagneDiscount);
    }

    public Integer getTotalBenefitAmount() {
        return appliedEvent.stream()
                .mapToInt(event -> event.getDiscountedMoney().toInt())
                .sum();
    }
}
