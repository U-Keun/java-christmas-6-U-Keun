package christmas.util;

public abstract class InputNumber implements InputValidator {
    private final Integer number;
    private static final String BLANK = " ";
    private static final String NULL_STRING = "";

    protected InputNumber(final String input) {
        checkBlank(input);
        number = isInteger(input);
        validateInstance();
    }

    private void checkBlank(String input) {
        input = input.replaceAll(BLANK, NULL_STRING);
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private Integer isInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public abstract void validateInstance();
}
