package christmas.model.food;

import christmas.model.Money;
import christmas.util.exception.ErrorMessage;
import christmas.util.exception.EventException;
import java.util.Arrays;
import java.util.Objects;

public interface Food {
    static Food fromName(final String name) {
        return MenuConfiguration.MENU_TYPES.stream()
                .map(menuType -> findMenu(menuType, name))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> EventException.of(ErrorMessage.INVALID_ORDER));
    }

    String getName();

    Money getPrice(int quantity);

    default boolean isNotBeverage() {
        return !(this instanceof Beverage);
    }

    private static Food findMenu(Class<? extends Food> enumClass, final String name) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(food -> food.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
