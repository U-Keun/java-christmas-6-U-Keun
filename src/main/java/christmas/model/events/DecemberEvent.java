package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import christmas.model.events.util.ChampagneDiscount;
import christmas.model.events.util.ChristmasDDayDiscount;
import christmas.model.events.util.HolidayDiscount;
import christmas.model.events.util.SpecialDiscount;
import christmas.model.events.util.WeekdayDiscount;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum DecemberEvent implements DiscountEvent {
    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인", new ChristmasDDayDiscount()::getDiscountAmount),
    WEEKDAY_EVENT("평일 할인", new WeekdayDiscount()::getDiscountAmount),
    HOLIDAY_EVENT("주말 할인", new HolidayDiscount()::getDiscountAmount),
    SPECIAL_DISCOUNT_EVENT("특별 할인", new SpecialDiscount()::getDiscountAmount),
    CHAMPAGNE_EVENT("증정 이벤트", new ChampagneDiscount()::getDiscountAmount);

    private final String eventName;
    private final BiFunction<LocalDate, Order, Money> discountedMoney;
    private static final DecemberEvent[] ENUMS = DecemberEvent.values();

    DecemberEvent(String eventName, BiFunction<LocalDate, Order, Money> function) {
        this.eventName = eventName;
        this.discountedMoney = function;
    }

    public static List<DiscountEvent> getAppliedEvents(LocalDate date, Order order) {
        return Arrays.stream(ENUMS)
                .filter(event -> !event.getDiscountedMoney(date, order).equals(Money.ZERO))
                .collect(Collectors.toList());
    }

    public Money getDiscountedMoney(LocalDate date, Order order) {
        return discountedMoney.apply(date, order);
    }

    public String getEventName() {
        return this.eventName;
    }
}
