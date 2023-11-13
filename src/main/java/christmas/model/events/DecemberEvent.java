package christmas.model.events;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;
import java.util.function.BiFunction;

public enum DecemberEvent {
    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인", new ChristmasDDayDiscount()::getDiscountAmount),
    WEEKDAY_EVENT("평일 할인", new WeekdayDiscount()::getDiscountAmount),
    HOLIDAY_EVENT("주말 할인", new HolidayDiscount()::getDiscountAmount),
    SPECIAL_DISCOUNT_EVENT("특별 할인", new SpecialDiscount()::getDiscountAmount),
    CHAMPAGNE_EVENT("증정 이벤트", new ChampagneDiscount()::getDiscountAmount);

    private final String eventName;
    private final BiFunction<LocalDate, Order, Money> discountedMoney;

    DecemberEvent(String eventName, BiFunction<LocalDate, Order, Money> function) {
        this.eventName = eventName;
        this.discountedMoney = function;
    }
}
