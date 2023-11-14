package christmas.funtion;

import christmas.constant.ProgressMessage;
import christmas.domain.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    ManageMenu manageMenu = new ManageMenu();
    ManageGift manageGift = new ManageGift();
    ManagePrice managePrice = new ManagePrice();
    ManageDiscount manageDiscount = new ManageDiscount();
    ManageBedge manageBedge = new ManageBedge();

    public void printMenu() {
        System.out.println(ProgressMessage.INPUT_MENU_AND_COUNT);
    }

    public void printHello() {
        System.out.println(ProgressMessage.START_HELLO);
    }

    public void printInputDate() {
        System.out.println(ProgressMessage.INPUT_VISIT_DATE);
    }

    public void printOrderMenu(String inputMenu) {
        printLineChange();
        List<String> orderMenu = manageMenu.printOrderMenu(inputMenu);
        System.out.println(ProgressMessage.PRINT_ORDER_MENU);
        for (int i = 0; i < orderMenu.size(); i++) {
            System.out.println(orderMenu.get(i));
        }
    }

    public void printEventPreview(int date) {
        System.out.printf(ProgressMessage.PRINT_EVENT, date);
    }

    public void printBeforDiscount(String inputMenu) {
        int totalPrice = managePrice.getTotalPrice(inputMenu);
        String result = printNumberComma(totalPrice);
        System.out.println("\n" + ProgressMessage.PRINT_BEFORE_DISCOUNT + "\n" + result + "원");
    }

    public void printGift(String inputMenu) {
        int num = manageGift.getGift(inputMenu);
        if (num == 1) {
            System.out.println("\n" + ProgressMessage.PRINT_GIVING_MENU + "\n" + "샴페인 1개");
        }
        if (num == 0) {
            System.out.println("\n" + ProgressMessage.PRINT_GIVING_MENU + "\n" + "없음");
        }
    }

    public void printEventThings(int divisionNum, String inputMenu, int day) {
        List<Integer> discount = manageDiscount.getAllDiscount(divisionNum, inputMenu, day);
        List<String> allResult = printNumbersComma(discount);
        int totalPrice = managePrice.getTotalPrice(inputMenu);
        System.out.println("\n" + ProgressMessage.PRINT_EVENT_THINGS);
        printChristmasEvent(divisionNum, inputMenu, day);
        printEventCondition(divisionNum, discount, allResult);
        printEvent(inputMenu);
        if (discount.size() == 0 && totalPrice <= 120000 && day >= 26) {
            System.out.println("없음");
        }
    }

    public void printEventCondition(int divisionNum, List<Integer> discount, List<String> allResult) {
        if (divisionNum == 1 && discount.size() != 0) {
            System.out.println("평일 할인: -" + allResult.get(0) + "원");
        }
        if (divisionNum == 2 && discount.size() != 0) {
            System.out.println("주말 할인: -" + allResult.get(0) + "원");
        }
        if (divisionNum == 3 && discount.size() != 0) {
            if (discount.get(0) != 0) {
                System.out.println("평일 할인: -" + allResult.get(0) + "원");
                System.out.println("특별 할인: -" + allResult.get(1) + "원");
            }
            if (discount.get(0) == 0) {
                System.out.println("특별 할인: -" + allResult.get(1) + "원");
            }
        }
    }

    public void printChristmasEvent(int divisionNum, String inputMenu, int day) {
        int discount = manageDiscount.getDayDiscount(day);
        String discountResult = printNumberComma(discount);
        if (day < 26) {
            System.out.println("크리스마스 디데이 할인: -" + discountResult + "원");
        }
    }

    public void printEvent(String inputMenu) {
        int totalPrice = managePrice.getTotalPrice(inputMenu);
        if (totalPrice >= 120000) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    public void printTotalDiscount(int divisionNum, String inputMenu, int day) {
        int discount = manageDiscount.getTotalDiscount(divisionNum, inputMenu, day);
        int totalPrice = managePrice.getTotalPrice(inputMenu);
        if (totalPrice >= 120000) {
            discount = discount + 25000;
        }
        String discountResult = printNumberComma(discount);
        System.out.println("\n" + ProgressMessage.PRINT_DISCOUNT);
        if (discount == 0) {
            System.out.println(discountResult + "원");
        }
        if (discount != 0) {
            System.out.println("-" + discountResult + "원");
        }
    }

    public void printTotalPay(int divisionNum, String inputMenu, int day) {
        int discount = manageDiscount.getTotalDiscount(divisionNum, inputMenu, day);
        int totalPrice = managePrice.getTotalPrice(inputMenu);
        int result = totalPrice - discount;
        String resultWithComma = printNumberComma(result);
        System.out.println("\n" + ProgressMessage.PRINT_AFTER_DISCOUNT);
        System.out.println(resultWithComma + "원");
    }

    public void printBedge(int divisionNum, String inputMenu, int day) {
        System.out.println("\n" + ProgressMessage.EVENT_BADGE);
        System.out.println(manageBedge.getBedge(divisionNum, inputMenu, day));
    }

    public void printLineChange() {
        System.out.println("\n");
    }

    public String printNumberComma(int result) {
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(result);
        return money;
    }

    public List<String> printNumbersComma(List<Integer> result) {
        DecimalFormat df = new DecimalFormat("###,###");
        List<String> allResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            allResult.add(df.format(result.get(i)));
        }
        return allResult;
    }
}
