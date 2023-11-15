package christmas.model.events.discount;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChristmasDDayDiscountTest {
    private final ChristmasDDayDiscount TEST_INSTANCE = new ChristmasDDayDiscount();

    @DisplayName("크리스마스 디데이 할인 가격 계산 작동 확인 테스트")
    @Test
    void calculateDiscountAmountTest() {
        Order mockedOrder = Mockito.mock(Order.class);
        LocalDate testDate = LocalDate.of(2023, 12, 19);

        Money result = TEST_INSTANCE.calculateDiscountAmount(testDate, mockedOrder);
        Money expected = Money.valueOf(2800);

        assertEquals(expected, result);
    }
}