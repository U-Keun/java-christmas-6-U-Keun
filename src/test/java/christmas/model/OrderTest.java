package christmas.model;

import static christmas.model.TestInstance.ORDER_TEST_INSTANCE;
import static christmas.model.TestInstance.TEST_INPUT;
import static org.junit.jupiter.api.Assertions.*;

import christmas.model.food.Appetizer;
import christmas.model.food.Beverage;
import christmas.model.food.Dessert;
import christmas.model.food.Food;
import christmas.model.food.MainDish;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @DisplayName("총 주문 금액 계산 작동 확인 테스트")
    @Test
    void getTotalOrderAmount() {
        Money totalAmount = ORDER_TEST_INSTANCE.getTotalOrderAmount();

        Money expected = Money.valueOf(79000);

        assertEquals(expected, totalAmount);
    }

    @DisplayName("특정 종류의 메뉴 개수를 구하는 메서드 작동 확인 테스트")
    @Test
    void getCountMenuTypeOfTest() {
        Map<Class<?>, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put(Appetizer.class, 1);
        expectedCounts.put(MainDish.class, 1);
        expectedCounts.put(Beverage.class, 1);
        expectedCounts.put(Dessert.class, 1);

        for (Map.Entry<Class<?>, Integer> entry : expectedCounts.entrySet()) {
            Integer actualCount = ORDER_TEST_INSTANCE.getCountMenuTypeOf((Class<? extends Food>) entry.getKey());
            assertEquals(entry.getValue(), actualCount);
        }
    }

    @DisplayName("주문 내역 확인 테스트")
    @Test
    void getOrderSpecificationTest() {
        Map<String, Integer> orderSpecification = ORDER_TEST_INSTANCE.getOrderSpecification();

        for (String menu : TEST_INPUT.keySet()) {
            assertEquals(1, orderSpecification.get(menu));
        }
    }
}