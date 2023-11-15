package christmas.model.events.discount;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import christmas.model.Money;
import christmas.model.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SpecialDiscountTest {
    private final SpecialDiscount TEST_INSTANCE = new SpecialDiscount();
    private final Money THOUSAND_WON = Money.valueOf(1000);

    @DisplayName("특별 할인 적용 확인 테스트 1")
    @Test
    void calculateDiscountAmountTest1() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate mockedDate = Mockito.mock(LocalDate.class);

        when(mockedDate.getDayOfWeek()).thenReturn(DayOfWeek.SUNDAY);

        Money result = TEST_INSTANCE.calculateDiscountAmount(mockedDate, mockedOrder);
        Money expected = THOUSAND_WON;

        assertEquals(expected, result);
    }

    @DisplayName("특별 할인 적용 확인 테스트 2")
    @Test
    void calculateDiscountAmountTest2() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate christmas = LocalDate.of(2023, 12, 25);

        Money result = TEST_INSTANCE.calculateDiscountAmount(christmas, mockedOrder);
        Money expected = THOUSAND_WON;

        assertEquals(expected, result);
    }

    @DisplayName("특별 할인 적용 확인 테스트 3")
    @Test
    void calculateDiscountAmountTest3() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate notSpecialDay = LocalDate.of(2023, 12, 26);

        Money result = TEST_INSTANCE.calculateDiscountAmount(notSpecialDay, mockedOrder);
        Money expected = Money.ZERO;

        assertEquals(expected, result);
    }
}