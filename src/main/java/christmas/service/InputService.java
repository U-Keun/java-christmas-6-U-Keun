package christmas.service;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Order;
import christmas.model.input.InputDayNumber;
import christmas.model.input.InputMenuMap;
import christmas.view.InputView;

public class InputService {
    private final InputView inputView;

    private InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public static InputService getInstance(InputView inputView) {
        return new InputService(inputView);
    }

    public void greetingMessage() {
        inputView.greeting();
    }

    public void requestDayNumberMessage() {
        inputView.requestDayNumber();
    }

    public Integer requestInputDayNumber() {
        String input = Console.readLine();
        return InputDayNumber.getInstance(input).getInputData();
    }

    public void requestMenuMessage() {
        inputView.requestMenu();
    }

    public Order requestInputMenu() {
        String input = Console.readLine();
        Order order = Order.getInstance(InputMenuMap.getInstance(input).getInputData());
        Console.close();
        return order;
    }
}
