package christmas.model.food;

import java.util.Arrays;

public enum Beverage implements Food<Beverage> {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Beverage fromName(String name) {
        return Arrays.stream(Beverage.values())
                .filter(appetizer -> appetizer.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
