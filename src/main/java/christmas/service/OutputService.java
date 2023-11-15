package christmas.service;

import christmas.dto.ReservationDTO;
import christmas.view.OutputView;

public class OutputService {
    private final OutputView outputView;

    private OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public static OutputService getInstance(OutputView outputView) {
        return new OutputService(outputView);
    }

    public void printResult(ReservationDTO reservationDTO) {
        outputView.printOverviewStartMessage(reservationDTO.getDate());
        outputView.printOrder(reservationDTO.getOrderedMenus());
        outputView.printOrderAmount(reservationDTO.getTotalOrderAmount());
        outputView.printGiveawayMenu(reservationDTO.hasGiveawayMenu());
        outputView.printBenefitSpecification(reservationDTO.getDiscountDetails());
        outputView.printBenefitAmount(reservationDTO.getTotalBenefitAmount());
        outputView.printPaymentAmount(reservationDTO.getTotalPaymentAmount());
        outputView.printEventBadge(reservationDTO.getEventBadge());
    }
}