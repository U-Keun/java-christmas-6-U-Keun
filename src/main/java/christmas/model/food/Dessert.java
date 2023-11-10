package christmas.model.food;

import java.util.Arrays;

public enum Dessert implements Food<Dessert> {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String name;
    private final int price;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Dessert fromName(String name) {
        return Arrays.stream(Dessert.values())
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
