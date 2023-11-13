package christmas.model.food;

public enum Appetizer implements Food {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000);

    private final String name;
    private final int price;

    Appetizer(final String name, final int price) {
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
