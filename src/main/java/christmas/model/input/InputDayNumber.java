package christmas.model.input;

import christmas.util.InputNumber;
import christmas.util.exception.ErrorMessage;
import christmas.util.exception.EventException;

public class InputDayNumber extends InputNumber {
    private InputDayNumber(String input) {
        super(input);
    }

    public static InputDayNumber getInstance(String input) {
        return new InputDayNumber(input);
    }

    @Override
    public void validateInstance() {
        checkValidDay();
    }

    private void checkValidDay() {
        if (number < 1 || number > 31) {
            throw EventException.of(ErrorMessage.INVALID_DAY_NUMBER);
        }
    }
}
