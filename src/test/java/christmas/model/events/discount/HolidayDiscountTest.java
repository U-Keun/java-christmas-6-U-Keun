package christmas.model.events.discount;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import christmas.model.Money;
import christmas.model.Order;
import christmas.model.food.MainDish;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HolidayDiscountTest {
    private final HolidayDiscount TEST_INSTANCE = new HolidayDiscount();

    @DisplayName("주말 할인 가격 계산 작동 확인 테스트 1")
    @Test
    void calculateDiscountAmountTest1() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate mockedDate = Mockito.mock(LocalDate.class);

        when(mockedDate.getDayOfWeek()).thenReturn(DayOfWeek.FRIDAY);
        when(mockedOrder.getCountMenuTypeOf(MainDish.class)).thenReturn(3);

        Money result = TEST_INSTANCE.calculateDiscountAmount(mockedDate, mockedOrder);
        Money expected = Money.valueOf(6069);

        assertEquals(expected, result);
    }

    @DisplayName("주말 할인 가격 계산 작동 확인 테스트 2")
    @Test
    void calculateDiscountAmountTest2() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate mockedDate = Mockito.mock(LocalDate.class);

        when(mockedDate.getDayOfWeek()).thenReturn(DayOfWeek.TUESDAY);

        Money result = TEST_INSTANCE.calculateDiscountAmount(mockedDate, mockedOrder);
        Money expected = Money.ZERO;

        assertEquals(expected, result);
    }
}