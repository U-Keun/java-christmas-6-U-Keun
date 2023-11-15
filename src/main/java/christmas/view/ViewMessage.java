package christmas.view;

public enum ViewMessage {
    /*
    입력 요청 메시지
     */
    GREETING_MESSAGE("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),
    REQUEST_DAY_NUMBER_MESSAGE("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    /*
    출력 관련 메시지
     */
    EVENT_OVERVIEW_START_MESSAGE("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리보기!"),
    ORDER_MENU_TAG("\n<주문 메뉴>\n"),
    ORDER_FORMAT("%s %d개\n"),
    TOTAL_ORDER_AMOUNT_TAG("<할인 전 총주문 금액>\n"),
    TOTAL_ORDER_AMOUNT_FORMAT("%,d원"),
    GIVEAWAY_MENU_TAG("\n<증정 메뉴>\n"),
    GIVEAWAY_MENU_FORMAT("샴페인 1개"),
    BENEFIT_SPECIFICATION_TAG("\n<혜택 내역>\n"),
    BENEFIT_SPECIFICATION_FORMAT("%s: -%,d원\n"),
    TOTAL_BENEFIT_AMOUNT_TAG("<총혜택 금액>\n"),
    TOTAL_BENEFIT_AMOUNT_FORMAT("%,d원"),
    TOTAL_PAYMENT_AMOUNT_TAG("\n<할인 후 예상 결제 금액>\n"),
    TOTAL_PAYMENT_AMOUNT_FORMAT("%,d원"),
    EVENT_BADGE_TAG("\n<12월 이벤트 배지>\n"),
    EVENT_BADGE("%s"),
    NONE("없음");
    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
