package christmas.view;

import static christmas.view.ViewMessage.GREETING_MESSAGE;
import static christmas.view.ViewMessage.REQUEST_DAY_NUMBER_MESSAGE;
import static christmas.view.ViewMessage.REQUEST_MENU_MESSAGE;

public class InputView {
    private static final Integer THIS_MONTH = 12;

    public void greeting() {
        System.out.println(GREETING_MESSAGE.getMessage(THIS_MONTH));
    }

    public void requestDayNumber() {
        System.out.println(REQUEST_DAY_NUMBER_MESSAGE.getMessage(THIS_MONTH));
    }

    public void requestMenu() {
        System.out.println(REQUEST_MENU_MESSAGE.getMessage());
    }
}
