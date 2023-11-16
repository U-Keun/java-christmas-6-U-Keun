package christmas.model.food;

import christmas.model.Money;

public enum MainDish implements Food {
    T_BONE_STAKE("티본스테이크", 55_000),
    BARBEQUE_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000);

    private final String name;
    private final Money price;

    MainDish(final String name, final int price) {
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
