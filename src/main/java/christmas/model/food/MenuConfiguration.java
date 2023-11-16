package christmas.model.food;

import java.util.List;

public class MenuConfiguration {
    static final List<Class<? extends Food>> MENU_TYPES = List.of(
            Appetizer.class,
            MainDish.class,
            Dessert.class,
            Beverage.class);
}
