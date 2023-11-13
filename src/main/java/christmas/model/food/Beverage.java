package christmas.model.food;

import christmas.model.Money;

public enum Beverage implements Food {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final Money price;

    Beverage(final String name, final int price) {
        this.name = name;
        this.price = Money.valueOf(price);
    }

    public String getName() {
        return this.name;
    }

    public Money getPrice(final int quantity) {
        return price.times(quantity);
    }
}
