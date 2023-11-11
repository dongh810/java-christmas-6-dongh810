package christmas.funtion;

import christmas.constant.ProgressMessage;

public class OutputView {
    public void printMenu() {
        System.out.println(ProgressMessage.INPUT_MENU_AND_COUNT);

    }
    public void printHello() {
        System.out.println(ProgressMessage.START_HELLO);
    }

    public void printInputDate() {
        System.out.println(ProgressMessage.INPUT_VISIT_DATE);
    }

    public void printOrderMenu() {
        System.out.println(ProgressMessage.PRINT_ORDER_MENU);
    }

    public void printEventPreview(int date) {
        System.out.printf(ProgressMessage.PRINT_EVENT,date);
    }

    public void printBeforDiscount() {
        System.out.println(ProgressMessage.PRINT_BEFORE_DISCOUNT);
    }

    public void printBedge() {
        System.out.println(ProgressMessage.EVENT_BADGE);
    }

    public void printLineChange() {
        System.out.println("\n");
    }
}
