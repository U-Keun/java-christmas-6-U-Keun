package christmas.model.food;

import christmas.model.Money;

public enum Dessert implements Food {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String name;
    private final Money price;

    Dessert(final String name, final int price) {
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
