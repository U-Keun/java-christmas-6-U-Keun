package christmas.model;

import christmas.model.food.Food;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    private final Map<Food, Integer> order;
    private static final Integer MAXIMUM_QUANTITY = 20;

    private Order(final Map<String, Integer> input) {
        order = convertInput(input);
        validateInstance();
    }

    public static Order getInstance(final Map<String, Integer> input) {
        return new Order(input);
    }

    public int getTotalOrderAmount() {
        return order.keySet().stream()
                .mapToInt(key -> key.getPrice(order.get(key)))
                .sum();
    }

    private Map<Food, Integer> convertInput(final Map<String, Integer> input) {
        return input.entrySet().stream()
                .collect(Collectors.toMap(entry -> Food.fromName(entry.getKey()), Map.Entry::getValue));
    }

    private void validateInstance() {
        checkValidQuantity();
        checkValidOrder();
    }

    private void checkValidQuantity() {
        if (countTotalQuantity() > MAXIMUM_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }

    private int countTotalQuantity() {
        return order.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void checkValidOrder() {
        if (hasOnlyBeverages()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }

    private boolean hasOnlyBeverages() {
        return order.keySet().stream()
                .filter(Food::isNotBeverage)
                .findFirst()
                .isEmpty();
    }
}