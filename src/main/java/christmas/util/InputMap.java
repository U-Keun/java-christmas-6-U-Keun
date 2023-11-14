package christmas.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class InputMap<A, B> implements InputValidator {
    private final Map<A, B> map;
    private String PAIR_SEPARATOR;
    private static final String DELIMITER = ",";
    private static final String BLANK = " ";
    private static final String NULL_STRING = "";

    protected InputMap(final String input) {
        setPairSeparator();
        map = convertInput(parseString(input));
        validateInstance();
    }

    private List<List<String>> parseString(final String input) {
        return Stream.of(input.split(DELIMITER))
                .map(str -> Arrays.asList(str.split(PAIR_SEPARATOR)))
                .peek(this::checkPair)
                .peek(this::checkBlank)
                .collect(Collectors.toList());
    }

    private void checkPair(final List<String> pair) {
        if (pair.size() != 2) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void checkBlank(final List<String> pair) {
        for (String element : pair) {
            if (element.isEmpty()) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

    protected abstract void setPairSeparator();

    protected abstract Map<A, B> convertInput(List<List<String>> stringList);

    public abstract void validateInstance();
}
