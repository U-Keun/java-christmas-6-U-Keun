package christmas.model.food;

import christmas.model.Money;
import java.util.Arrays;
import java.util.Objects;

public interface Food {
    static Food fromName(final String name) {
        return MenuConfiguration.MENU_TYPES.stream()
                .map(menuType -> findMenu(menuType, name))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요."));
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
