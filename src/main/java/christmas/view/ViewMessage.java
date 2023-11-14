package christmas.view;

public enum ViewMessage {
    /*
    입력 요청 메시지
     */
    GREETING_MESSAGE("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),
    REQUEST_DAY_NUMBER_MESSAGE("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object ... args) {
        return String.format(message, args);
    }
}
