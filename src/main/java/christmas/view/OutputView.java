package christmas.view;

import static christmas.view.ViewMessage.BENEFIT_SPECIFICATION_FORMAT;
import static christmas.view.ViewMessage.BENEFIT_SPECIFICATION_TAG;
import static christmas.view.ViewMessage.EVENT_BADGE;
import static christmas.view.ViewMessage.EVENT_BADGE_TAG;
import static christmas.view.ViewMessage.EVENT_OVERVIEW_START_MESSAGE;
import static christmas.view.ViewMessage.GIVEAWAY_MENU_FORMAT;
import static christmas.view.ViewMessage.GIVEAWAY_MENU_TAG;
import static christmas.view.ViewMessage.NONE;
import static christmas.view.ViewMessage.ORDER_FORMAT;
import static christmas.view.ViewMessage.ORDER_MENU_TAG;
import static christmas.view.ViewMessage.TOTAL_BENEFIT_AMOUNT_FORMAT;
import static christmas.view.ViewMessage.TOTAL_BENEFIT_AMOUNT_TAG;
import static christmas.view.ViewMessage.TOTAL_ORDER_AMOUNT_FORMAT;
import static christmas.view.ViewMessage.TOTAL_ORDER_AMOUNT_TAG;
import static christmas.view.ViewMessage.TOTAL_PAYMENT_AMOUNT_FORMAT;
import static christmas.view.ViewMessage.TOTAL_PAYMENT_AMOUNT_TAG;

import java.time.LocalDate;
import java.util.Map;

public class OutputView {
    public void printOverviewStartMessage(LocalDate date) {
        System.out.println(EVENT_OVERVIEW_START_MESSAGE.getMessage(date.getMonthValue(), date.getDayOfMonth()));
    }

    public void printOrder(Map<String, Integer> orderedMenus) {
        printMessageWithMap(ORDER_MENU_TAG, ORDER_FORMAT, orderedMenus);
    }

    public void printOrderAmount(Integer totalOrderAmount) {
        printMessage(TOTAL_ORDER_AMOUNT_TAG, TOTAL_ORDER_AMOUNT_FORMAT, totalOrderAmount);
    }

    public void printGiveawayMenu(String giveawayMenu) {
        printMessage(GIVEAWAY_MENU_TAG, GIVEAWAY_MENU_FORMAT, giveawayMenu);
    }

    public void printBenefitSpecification(Map<String, Integer> discountDetails) {
        printMessageWithMap(BENEFIT_SPECIFICATION_TAG, BENEFIT_SPECIFICATION_FORMAT, discountDetails);
    }

    public void printBenefitAmount(Integer totalBenefitAmount) {
        printMessage(TOTAL_BENEFIT_AMOUNT_TAG, TOTAL_BENEFIT_AMOUNT_FORMAT, totalBenefitAmount);
    }

    public void printPaymentAmount(Integer totalPaymentAmount) {
        printMessage(TOTAL_PAYMENT_AMOUNT_TAG, TOTAL_PAYMENT_AMOUNT_FORMAT, totalPaymentAmount);
    }

    public void printEventBadge(String eventBadge) {
        printMessage(EVENT_BADGE_TAG, EVENT_BADGE, eventBadge);
    }

    private void printMessage(ViewMessage tag, ViewMessage format, Object... args) {
        StringBuilder print = new StringBuilder();
        print.append(tag.getMessage());
        print.append(getMessageWithArgs(format, args));
        System.out.println(print);
    }

    private String getMessageWithArgs(ViewMessage format, Object... args) {
        if (args == null || (args.length == 1 && args[0] == null)) {
            return NONE.getMessage();
        }
        return format.getMessage(args);
    }

    private void printMessageWithMap(ViewMessage tag, ViewMessage format, Map<String, Integer> map) {
        StringBuilder print = new StringBuilder();
        print.append(tag.getMessage());
        print.append(getMessageWithMap(format, map));
        System.out.println(print);
    }

    private String getMessageWithMap(ViewMessage format, Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return NONE.getMessage();
        }

        StringBuilder mapMessage = new StringBuilder();
        map.forEach((key, value) -> mapMessage.append(format.getMessage(key, value)));
        return mapMessage.toString();
    }
}