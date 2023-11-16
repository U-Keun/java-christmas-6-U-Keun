package christmas.util.input;

import christmas.util.exception.ErrorMessage;
import christmas.util.exception.EventException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class InputMap<A, B> implements InputValidator {
    protected final Map<A, B> map;
    protected String PAIR_SEPARATOR;
    private static final String DELIMITER = ",";

    protected InputMap(final String input) {
        setPairSeparator();
        List<List<String>> parsedString = checkDuplicatedKey(parseString(input));
        map = convertInput(parsedString);
        validateInstance();
    }

    @Override
    public Map<A, B> getInputData() {
        return map;
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
            throw EventException.of(ErrorMessage.INVALID_ORDER);
        }
    }

    private void checkBlank(final List<String> pair) {
        for (String element : pair) {
            if (element.isEmpty()) {
                throw EventException.of(ErrorMessage.INVALID_ORDER);
            }
        }
    }

    private List<List<String>> checkDuplicatedKey(List<List<String>> parsedString) {
        Set<String> set = new HashSet<>();
        for (List<String> pair : parsedString) {
            if (!set.add(pair.get(0))) {
                throw EventException.of(ErrorMessage.INVALID_ORDER);
            }
        }
        return parsedString;
    }

    protected abstract void setPairSeparator();

    protected abstract Map<A, B> convertInput(List<List<String>> pairList);

    public abstract void validateInstance();
}