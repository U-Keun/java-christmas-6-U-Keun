package christmas.service;

import christmas.dto.ReservationDTO;
import christmas.model.AppliedEvent;
import christmas.model.EventBadge;
import christmas.model.Money;
import christmas.model.Order;
import java.time.LocalDate;

public class ReservationService {
    private final LocalDate date;
    private final Order order;
    private final AppliedEvent appliedEvent;
    private static final Integer THIS_YEAR = 2023;
    private static final Integer THIS_MONTH = 12;
    private static final String STAR = "별";
    private static final String TREE = "트리";
    private static final String SANTA = "산타";
    private static final Money CHAMPAGNE_PRICE = Money.valueOf(25000);
    private ReservationService(Integer dayNumber, Order order) {
        this.date = LocalDate.of(THIS_YEAR, THIS_MONTH, dayNumber);
        this.order = order;
        appliedEvent = AppliedEvent.getInstance(date, order);
    }

    public static ReservationService getInstance(Integer dayNumber, Order order) {
        return new ReservationService(dayNumber, order);
    }

    public ReservationDTO getReservationDTO() {
        ReservationDTO reservationDTO = new ReservationDTO(date);

        setDataByOrder(reservationDTO);

        setDataByAppliedEvent(reservationDTO);

        reservationDTO.setTotalPaymentAmount(calculateTotalPaymentAmount());

        reservationDTO.setEventBadge(getEventBadge());
        return reservationDTO;
    }

    private void setDataByOrder(ReservationDTO reservationDTO) {
        reservationDTO.setOrderedMenus(order.getOrderSpecification());
        reservationDTO.setTotalOrderAmount(order.getTotalOrderAmount().toInt());
    }

    private void setDataByAppliedEvent(ReservationDTO reservationDTO) {
        reservationDTO.setDiscountDetails(appliedEvent.getDiscountDetails(date, order));
        reservationDTO.setGiveawayMenu(appliedEvent.getGiveawayMenu());

        Money negatedBenefitAmount = appliedEvent.getTotalBenefitAmount(date, order).times(-1);
        reservationDTO.setTotalBenefitAmount(negatedBenefitAmount.toInt());
    }

    private Integer calculateTotalPaymentAmount() {
        Money payment = order.getTotalOrderAmount().minus(appliedEvent.getTotalBenefitAmount(date, order));
        if (appliedEvent.getGiveawayMenu() != null) {
            payment = payment.plus(CHAMPAGNE_PRICE);
        }
        return payment.toInt();
    }

    private String getEventBadge() {
        Money totalBenefitAmount = appliedEvent.getTotalBenefitAmount(date, order);
        return EventBadge.getEventBadge(totalBenefitAmount);
    }
}