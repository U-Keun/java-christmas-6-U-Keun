package christmas.model.food;

import christmas.model.Money;

public enum Appetizer implements Food {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000);

    private final String name;
    private final Money price;

    Appetizer(final String name, final int price) {
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
