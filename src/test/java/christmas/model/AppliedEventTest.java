package christmas.model;

import static christmas.model.TestInstance.EVENTS_AFTER_CHRISTMAS;
import static christmas.model.TestInstance.EVENTS_BEFORE_CHRISTMAS;
import static christmas.model.TestInstance.ORDER_TEST_INSTANCE;
import static christmas.model.TestInstance.TEST_DATE_AFTER_CHRISTMAS;
import static christmas.model.TestInstance.TEST_DATE_BEFORE_CHRISTMAS;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppliedEventTest {

    @DisplayName("크리스마스 이전 평일 할인 내역 확인 테스트")
    @Test
    void getDiscountDetailsTest1() {
        Map<String, Integer> discountDetails = EVENTS_BEFORE_CHRISTMAS.getDiscountDetails(TEST_DATE_BEFORE_CHRISTMAS, ORDER_TEST_INSTANCE);

        assertEquals(2023, discountDetails.get("평일 할인"));

        assertEquals(1000, discountDetails.get("특별 할인"));

        assertEquals(1900, discountDetails.get("크리스마스 디데이 할인"));
    }

    @DisplayName("크리스마스 이후 주말 할인 내역 확인 테스트")
    @Test
    void getDiscountDetailsTest2() {
        Map<String, Integer> discountDetails = EVENTS_AFTER_CHRISTMAS.getDiscountDetails(TEST_DATE_AFTER_CHRISTMAS, ORDER_TEST_INSTANCE);

        assertEquals(2023, discountDetails.get("주말 할인"));
    }

    @DisplayName("총 혜택 금액 계산 테스트")
    @Test
    void getTotalBenefitAmountTest() {
        Money totalBenefit = EVENTS_BEFORE_CHRISTMAS.getTotalBenefitAmount(TEST_DATE_BEFORE_CHRISTMAS, ORDER_TEST_INSTANCE);

        Money expected = Money.valueOf(4923);

        assertEquals(expected, totalBenefit);
    }
}