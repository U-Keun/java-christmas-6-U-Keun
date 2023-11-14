package christmas.dto;

import java.time.LocalDate;
import java.util.Map;

public class ReservationDTO {
    private LocalDate date;
    private Map<String, Integer> orderedMenus;
    private Integer totalOrderAmount;
    private Map<String, Integer> discountDetails;
    private boolean GiveawayMenu;
    private Integer totalBenefitAmount;
    private Integer totalPaymentAmount;
    private String eventBadge;

    public ReservationDTO(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<String, Integer> getOrderedMenus() {
        return orderedMenus;
    }

    public void setOrderedMenus(Map<String, Integer> orderedMenus) {
        this.orderedMenus = orderedMenus;
    }

    public Integer getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(Integer totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public Map<String, Integer> getDiscountDetails() {
        return discountDetails;
    }

    public void setDiscountDetails(Map<String, Integer> discountDetails) {
        this.discountDetails = discountDetails;
    }

    public boolean isGiveawayMenu() {
        return GiveawayMenu;
    }

    public void setGiveawayMenu(boolean giveawayMenu) {
        GiveawayMenu = giveawayMenu;
    }

    public Integer getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public void setTotalBenefitAmount(Integer totalBenefitAmount) {
        this.totalBenefitAmount = totalBenefitAmount;
    }

    public Integer getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(Integer totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getEventBadge() {
        return eventBadge;
    }

    public void setEventBadge(String eventBadge) {
        this.eventBadge = eventBadge;
    }
}