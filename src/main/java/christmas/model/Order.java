package christmas.model;

import christmas.model.food.Food;
import christmas.util.exception.ErrorMessage;
import christmas.util.exception.EventException;
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

    public Money getTotalOrderAmount() {
        return order.entrySet().stream()
                .map(entry -> entry.getKey().getPrice(entry.getValue()))
                .reduce(Money.ZERO, Money::plus);
    }

    public Integer getCountMenuTypeOf(Class<? extends Food> menuType) {
        return order.keySet().stream()
                .filter(menuType::isInstance)
                .mapToInt(order::get)
                .sum();
    }

    public Map<String, Integer> getOrderSpecification() {
        return order.keySet().stream()
                .collect(Collectors.toMap(Food::getName, order::get));
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
            throw EventException.of(ErrorMessage.INVALID_ORDER);
        }
    }

    private int countTotalQuantity() {
        return order.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void checkValidOrder() {
        if (hasOnlyBeverages()) {
            throw EventException.of(ErrorMessage.INVALID_ORDER);
        }
    }

    private boolean hasOnlyBeverages() {
        return order.keySet().stream()
                .filter(Food::isNotBeverage)
                .findFirst()
                .isEmpty();
    }
}