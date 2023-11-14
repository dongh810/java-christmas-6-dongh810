package christmas;

import christmas.domain.ManageCalendar;
import christmas.funtion.InputView;
import christmas.funtion.OutputView;

public class Christmas {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ManageCalendar manageCalendar = new ManageCalendar();
    String orderMenu;
    int date;

    public void startProgram() {
        outputView.printHello();
        try {
            restartDateInputProgram();
            restartMenuInputProgram();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            restartDateInputProgram();
            restartMenuInputProgram();
        }
        outputView.printEventPreview(date);
        printResult();
    }

    public void restartDateInputProgram() {
        try {
            outputView.printInputDate();
            date = inputView.readDate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            outputView.printInputDate();
            date = inputView.readDate();
        }
    }

    public void restartMenuInputProgram() {
        try {
            outputView.printMenu();
            orderMenu = inputView.readMenu();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            outputView.printMenu();
            orderMenu = inputView.readMenu();
        }
    }

    public void printResult() {
        outputView.printOrderMenu(orderMenu);
        outputView.printBeforDiscount(orderMenu);
        outputView.printGift(orderMenu);
        outputView.printEventThings(manageCalendar.getDate(date), orderMenu, date);
        outputView.printTotalDiscount(manageCalendar.getDate(date), orderMenu, date);
        outputView.printTotalPay(manageCalendar.getDate(date), orderMenu, date);
        outputView.printBedge(manageCalendar.getDate(date), orderMenu, date);
    }
}
