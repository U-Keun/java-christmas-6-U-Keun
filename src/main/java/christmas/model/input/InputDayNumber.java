package christmas.model.input;

import christmas.util.InputNumber;

public class InputDayNumber extends InputNumber {
    protected InputDayNumber(String input) {
        super(input);
    }

    @Override
    public void validateInstance() {
        checkValidDay();
    }

    private void checkValidDay() {
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
