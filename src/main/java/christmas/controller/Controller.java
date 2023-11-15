package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public interface Controller {
    static Controller generateReservationController() {
        return new ReservationController(new InputView(), new OutputView());
    }
    void start();
}
