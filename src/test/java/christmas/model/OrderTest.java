package christmas.model;

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
    private final Map<String, Integer> testInput = Map.of(
            "양송이수프", 1,
            "제로콜라", 1,
            "티본스테이크",1,
            "초코케이크",1);
    private final Order testOrder = Order.getInstance(testInput);

    @DisplayName("총 주문 금액 계산 작동 확인 테스트")
    @Test
    void getTotalOrderAmount() {
        Money totalAmount = testOrder.getTotalOrderAmount();

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
            Integer actualCount = testOrder.getCountMenuTypeOf((Class<? extends Food>) entry.getKey());
            assertEquals(entry.getValue(), actualCount);
        }
    }

    @DisplayName("주문 내역 확인 테스트")
    @Test
    void getOrderSpecificationTest() {
        Map<String, Integer> orderSpecification = testOrder.getOrderSpecification();

        for (String menu : testInput.keySet()) {
            assertEquals(1, orderSpecification.get(menu));
        }
    }
}