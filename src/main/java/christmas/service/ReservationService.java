package christmas.service;

import christmas.dto.ReservationDTO;
import christmas.model.AppliedEvent;
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

        reservationDTO.setTotalPaymentAmount(calculateTotalPaymentAmount(reservationDTO));

        reservationDTO.setEventBadge(getEventBadge(reservationDTO));
        return reservationDTO;
    }

    private void setDataByOrder(ReservationDTO reservationDTO) {
        reservationDTO.setOrderedMenus(order.getOrderSpecification());
        reservationDTO.setTotalOrderAmount(order.getTotalOrderAmount().toInt());
    }

    private void setDataByAppliedEvent(ReservationDTO reservationDTO) {
        reservationDTO.setDiscountDetails(appliedEvent.getDiscountDetails());
        reservationDTO.setGiveawayMenu(appliedEvent.hasGiveawayMenu());
        reservationDTO.setTotalBenefitAmount(appliedEvent.getTotalBenefitAmount());
    }

    private Integer calculateTotalPaymentAmount(ReservationDTO reservationDTO) {
        Integer paymentAmount = reservationDTO.getTotalOrderAmount() - reservationDTO.getTotalBenefitAmount();
        if (reservationDTO.isGiveawayMenu()) {
            paymentAmount += 25000;
        }
        return paymentAmount;
    }

    private String getEventBadge(ReservationDTO reservationDTO) {
        if (reservationDTO.getTotalBenefitAmount() >= 20000) {
            return SANTA;
        }
        if (reservationDTO.getTotalBenefitAmount() >= 10000) {
            return TREE;
        }
        if (reservationDTO.getTotalBenefitAmount() >= 5000) {
            return STAR;
        }
        return null;
    }
}