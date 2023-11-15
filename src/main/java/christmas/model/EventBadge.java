package christmas.model;

import java.util.Arrays;
import java.util.function.Function;

public enum EventBadge {
    SANTA("산타", money -> money.isGreaterThanOrEqual(Money.valueOf(20000))),
    TREE("트리", money -> money.isGreaterThanOrEqual(Money.valueOf(10000))),
    STAR("별", money -> money.isGreaterThanOrEqual(Money.valueOf(5000)));

    private final String badge;
    private final Function<Money, Boolean> isSatisfied;
    private static final EventBadge[] ENUMS = EventBadge.values();

    EventBadge(String badge, Function<Money, Boolean> isSatisfied) {
        this.badge = badge;
        this.isSatisfied = isSatisfied;
    }

    public static String getEventBadge(Money money) {
        return Arrays.stream(ENUMS)
                .filter(eventBadge -> eventBadge.checkSatisfied(money))
                .findFirst()
                .map(EventBadge::getBadge)
                .orElse(null);
    }

    private Boolean checkSatisfied(Money money) {
        return isSatisfied.apply(money);
    }

    public String getBadge() {
        return badge;
    }
}
