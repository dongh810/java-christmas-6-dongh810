package christmas.domain;

public class ManageGift {

    ManagePrice managePrice = new ManagePrice();

    public int getGift(String inputMenu) {
        int price = managePrice.getTotalPrice(inputMenu);
        if (price >= 120000) {
            return 1;
        }
        return 0;
    }
}
