package christmas.model;

import java.time.LocalDate;
import java.util.Map;

public class TestInstance {
    public static final LocalDate TEST_DATE_BEFORE_CHRISTMAS = LocalDate.of(2023, 12, 10);
    public static final LocalDate TEST_DATE_AFTER_CHRISTMAS = LocalDate.of(2023, 12, 29);
    public static final Map<String, Integer> TEST_INPUT = Map.of(
            "양송이수프", 1,
            "제로콜라", 1,
            "티본스테이크",1,
            "초코케이크",1);
    public static final Order ORDER_TEST_INSTANCE = Order.getInstance(TEST_INPUT);
    public static final AppliedEvent EVENTS_BEFORE_CHRISTMAS = AppliedEvent.getInstance(TEST_DATE_BEFORE_CHRISTMAS, ORDER_TEST_INSTANCE);
    public static final AppliedEvent EVENTS_AFTER_CHRISTMAS = AppliedEvent.getInstance(TEST_DATE_AFTER_CHRISTMAS, ORDER_TEST_INSTANCE);
}
