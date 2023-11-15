package christmas.util;

import christmas.util.exception.ErrorMessage;
import christmas.util.exception.EventException;

public abstract class InputNumber implements InputValidator {
    protected final Integer number;
    private static final String BLANK = " ";
    private static final String NULL_STRING = "";

    protected InputNumber(final String input) {
        checkBlank(input);
        number = isInteger(input);
        validateInstance();
    }

    @Override
    public Integer getInputData() {
        return number;
    }

    private void checkBlank(String input) {
        input = input.replaceAll(BLANK, NULL_STRING);
        if (input.isBlank()) {
            throw EventException.of(ErrorMessage.INVALID_DAY_NUMBER);
        }
    }

    private Integer isInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw EventException.of(ErrorMessage.INVALID_DAY_NUMBER);
        }
    }

    public abstract void validateInstance();
}
