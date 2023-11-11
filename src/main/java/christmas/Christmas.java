package christmas;

import christmas.domain.ManageCalendar;
import christmas.domain.ManageDiscount;
import christmas.domain.ManageMenu;
import christmas.funtion.InputView;
import christmas.funtion.OutputView;

public class Christmas {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ManageMenu manageMenu = new ManageMenu();
    ManageCalendar manageCalendar = new ManageCalendar();
    ManageDiscount manageDiscount = new ManageDiscount();
    String orderMenu;
    int date;


    public void startProgram() {
        outputView.printHello();
        outputView.printInputDate();
        date = inputView.readDate();
        outputView.printMenu();
        orderMenu = inputView.readMenu();
        manageMenu.countEachMenuForDiscount(orderMenu);
        outputView.printEventPreview(date);
    }

    public void printResult() {
        outputView.printLineChange();
        outputView.printOrderMenu();
        manageMenu.printOrderMenu(orderMenu);
    }
}
