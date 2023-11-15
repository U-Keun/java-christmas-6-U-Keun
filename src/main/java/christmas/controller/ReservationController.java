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
        Integer dayNumber = requestDayNumber();
        Order order = requestMenu();
        ReservationDTO reservationDTO = getReservationInformation(dayNumber, order);

        outputService.printResult(reservationDTO);
    }

    private Integer requestDayNumber() {
        inputService.requestDayNumberMessage();
        return Retry.retryOnException(inputService::requestInputDayNumber);
    }

    private Order requestMenu() {
        inputService.requestMenuMessage();
        return Retry.retryOnException(inputService::requestInputMenu);
    }

    private ReservationDTO getReservationInformation(Integer dayNumber, Order order) {
        ReservationService reservationService = ReservationService.getInstance(dayNumber, order);
        return reservationService.getReservationDTO();
    }
}