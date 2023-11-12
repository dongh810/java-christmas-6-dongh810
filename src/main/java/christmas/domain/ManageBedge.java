package christmas.domain;

public class ManageBedge {

    ManagePrice managePrice = new ManagePrice();
    ManageDiscount manageDiscount = new ManageDiscount();


    public String getBedge(int divisionNum, String inputMenu, int day) {
        String bedge = "없음";
        int totalPrice = managePrice.getTotalPrice(inputMenu);
        int totalDiscount = manageDiscount.getTotalDiscount(divisionNum, inputMenu, day);
        if (totalPrice >= 120000) {
            totalDiscount = totalDiscount + 25000;
        }
        if (totalDiscount >= 5000 && totalDiscount < 10000) {
            bedge = "별";
        }
        if (totalDiscount >= 10000 && totalDiscount < 20000) {
            bedge = "트리";
        }
        if (totalDiscount >= 20000) {
            bedge = "산타";
        }
        return bedge;
    }
}
