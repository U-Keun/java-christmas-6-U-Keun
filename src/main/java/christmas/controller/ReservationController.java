package christmas.controller;

import christmas.dto.ReservationDTO;
import christmas.model.Order;
import christmas.service.InputService;
import christmas.service.OutputService;
import christmas.service.ReservationService;
import christmas.util.Retry;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ReservationController implements Controller {
    private final InputService inputService;
    private final OutputService outputService;

    ReservationController(InputView inputView, OutputView outputView) {
        this.inputService = InputService.getInstance(inputView);
        this.outputService = OutputService.getInstance(outputView);
    }

    public void start() {
        inputService.greetingMessage();
        inputService.requestDayNumberMessage();
        Integer dayNumber = Retry.retryOnException(inputService::requestInputDayNumber);

        inputService.requestMenuMessage();
        Order order = Retry.retryOnException(inputService::requestInputMenu);

        ReservationService reservationService = ReservationService.getInstance(dayNumber, order);
        ReservationDTO reservationDTO = reservationService.getReservationDTO();

        outputService.printResult(reservationDTO);
    }
}
