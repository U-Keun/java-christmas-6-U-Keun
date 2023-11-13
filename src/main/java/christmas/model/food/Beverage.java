package christmas.model.food;

public enum Beverage implements Food {
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    Beverage(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice(final int quantity) {
        return this.price * quantity;
    }
}
