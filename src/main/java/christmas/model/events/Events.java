package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import christmas.model.events.discount.ChampagneDiscount;
import christmas.model.events.discount.ChristmasDDayDiscount;
import christmas.model.events.discount.HolidayDiscount;
import christmas.model.events.discount.SpecialDiscount;
import christmas.model.events.discount.WeekdayDiscount;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Events implements DiscountEvent {
    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인", new ChristmasDDayDiscount()::getDiscountAmount),
    WEEKDAY_EVENT("평일 할인", new WeekdayDiscount()::getDiscountAmount),
    HOLIDAY_EVENT("주말 할인", new HolidayDiscount()::getDiscountAmount),
    SPECIAL_DISCOUNT_EVENT("특별 할인", new SpecialDiscount()::getDiscountAmount),
    CHAMPAGNE_EVENT("증정 이벤트", new ChampagneDiscount()::getDiscountAmount);

    private final String eventName;
    private final BiFunction<LocalDate, Order, Money> discountedMoney;
    private static final Events[] ENUMS = Events.values();

    Events(String eventName, BiFunction<LocalDate, Order, Money> function) {
        this.eventName = eventName;
        this.discountedMoney = function;
    }

    public static List<DiscountEvent> getAppliedEvents(LocalDate date, Order order) {
        return Arrays.stream(ENUMS)
                .filter(event -> isApplied(event, date, order))
                .collect(Collectors.toList());
    }

    private static boolean isApplied(Events event, LocalDate date, Order order) {
        return !event.getDiscountedMoney(date, order).equals(Money.ZERO);
    }

    public Money getDiscountedMoney(LocalDate date, Order order) {
        return discountedMoney.apply(date, order);
    }

    public String getEventName() {
        return this.eventName;
    }
}
