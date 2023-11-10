package christmas.model.food;

public interface Food<T> {
    T fromName(String name);

    String getName();

    int getPrice();

    default boolean isBeverage() {
        return this instanceof Beverage;
    }
}
