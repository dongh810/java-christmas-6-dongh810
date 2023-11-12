package christmas;

import christmas.domain.ManageCalendar;
import christmas.domain.ManageDiscount;
import christmas.domain.ManageMenu;
import christmas.domain.ManagePrice;
import christmas.funtion.InputView;
import christmas.funtion.OutputView;

public class Christmas {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ManageMenu manageMenu = new ManageMenu();
    ManageCalendar manageCalendar = new ManageCalendar();
    ManageDiscount manageDiscount = new ManageDiscount();
    ManagePrice managePrice = new ManagePrice();
    String orderMenu;
    int date;


    public void startProgram() {
        outputView.printHello();
        outputView.printInputDate();
        date = inputView.readDate();
        outputView.printMenu();
        orderMenu = inputView.readMenu();
        outputView.printEventPreview(date);
    }

    public void printResult() {
        outputView.printOrderMenu(orderMenu);
        outputView.printBeforDiscount(orderMenu);
        outputView.printGift(orderMenu);
        outputView.printEventThings(manageCalendar.getDate(date),orderMenu,date);
        outputView.printTotalDiscount(manageCalendar.getDate(date),orderMenu,date);
        outputView.printTotalPay(manageCalendar.getDate(date),orderMenu,date);
        outputView.printBedge(manageCalendar.getDate(date),orderMenu,date);
    }
}
