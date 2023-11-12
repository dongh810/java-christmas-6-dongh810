package christmas.domain;

import christmas.constant.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagePrice {

    Menu menu = new Menu();
    ManageMenu manageMenu = new ManageMenu();
    HashMap<String, Integer> allMenu = menu.setAllMenu();
    List<String> menuString = new ArrayList<>();
    List<String> menuCountString = new ArrayList<>();

    public int getTotalPrice(String inputMenu) {
        HashMap<Integer, Integer> menuPrice = getMenuPrice(inputMenu);
        int totalPrice = 0;
        for (Map.Entry<Integer, Integer> menu : menuPrice.entrySet()) {
            totalPrice += menu.getKey() * menu.getValue();
        }
        return totalPrice;
    }

    public HashMap<Integer, Integer> getMenuPrice(String inputMenu) {
        String[] split = inputMenu.split(",");
        HashMap<Integer, Integer> priceWithCount = new HashMap<Integer, Integer>();
        menuString = manageMenu.sortMenu(split);
        menuCountString = manageMenu.getMenuCount(split);
        for (int i = 0; i < split.length; i++) {
            priceWithCount.put(allMenu.get(menuString.get(i)), Integer.parseInt(menuCountString.get(i)));
        }
        return priceWithCount;
    }
}