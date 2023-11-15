package christmas.model.input;

import christmas.util.InputNumber;

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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
