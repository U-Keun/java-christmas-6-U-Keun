package christmas.model.food;

import java.util.Arrays;

public enum Appetizer implements Food<Appetizer> {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000);

    private final String name;
    private final int price;

    Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Appetizer fromName(String name) {
        return Arrays.stream(Appetizer.values())
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
