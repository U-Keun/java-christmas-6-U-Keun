package christmas.model.food;

import java.util.Arrays;

public interface Food<T> {
    static <T extends Enum<T> & Food<T>> T fromName(Class<T> enumClass, String name) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(food -> food.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    String getName();

    int getPrice();

    default boolean isBeverage() {
        return this instanceof Beverage;
    }
}
