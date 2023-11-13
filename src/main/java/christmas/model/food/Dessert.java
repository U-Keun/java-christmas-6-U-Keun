package christmas.model.food;

public enum Dessert implements Food {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String name;
    private final int price;

    Dessert(final String name, final int price) {
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
