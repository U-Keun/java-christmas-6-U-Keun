package christmas.model.input;

import christmas.util.InputMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputMenuMap extends InputMap<String, Integer> {
    private static final String MENU_SEPARATOR = "-";
    private InputMenuMap(final String input) {
        super(input);
    }

    public static InputMenuMap getInstance(String input) {
        return new InputMenuMap(input);
    }

    @Override
    protected void setPairSeparator() {
        this.PAIR_SEPARATOR = MENU_SEPARATOR;
    }

    @Override
    public void validateInstance() {
        checkMenuCount();
    }

    @Override
    protected Map<String, Integer> convertInput(List<List<String>> pairList) {
        return pairList.stream()
                .collect(Collectors.toMap(pair -> pair.get(0), pair -> isInteger(pair.get(1))));
    }

    private Integer isInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkMenuCount() {
        for (Integer menuCount : map.values()) {
            if (menuCount < 1 || menuCount > 20) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
