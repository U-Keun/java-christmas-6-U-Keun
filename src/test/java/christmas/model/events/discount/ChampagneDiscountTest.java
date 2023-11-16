package christmas.model.events.discount;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChampagneDiscountTest {
    private final ChampagneDiscount TEST_INSTANCE = new ChampagneDiscount();

    @DisplayName("할인 가격 계산 작동 확인 테스트 1")
    @Test
    void calculateDiscountAmountTest1() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate mockedDate = Mockito.mock(LocalDate.class);

        when(mockedOrder.getTotalOrderAmount()).thenReturn(Money.valueOf(130000));

        Money result = TEST_INSTANCE.calculateDiscountAmount(mockedDate, mockedOrder);
        Money expected = Money.valueOf(25000);

        assertEquals(expected, result);
    }

    @DisplayName("할인 가격 계산 작동 확인 테스트 2")
    @Test
    void calculateDiscountAmountTest2() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate mockedDate = Mockito.mock(LocalDate.class);

        when(mockedOrder.getTotalOrderAmount()).thenReturn(Money.valueOf(10000));

        Money result = TEST_INSTANCE.calculateDiscountAmount(mockedDate, mockedOrder);
        Money expected = Money.ZERO;

        assertEquals(expected, result);
    }
}