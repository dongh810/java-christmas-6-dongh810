package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.MenuCount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ManageMenu {

    Menu menu = new Menu();
    HashMap<String, Integer> main = menu.setMain();
    HashMap<String, Integer> dessert = menu.setDessert();
    HashMap<String, Integer> epitiger = menu.setEpitiger();
    HashMap<String, Integer> drink = menu.setDrink();
    List<String> menuString = new ArrayList<>();
    List<String> menuCountString = new ArrayList<>();
    int mainCount, dessertCount, drinkCount, epitigerCount;

    public MenuCount countEachMenuForDiscount(String inputMenu) {
        String[] split = inputMenu.split(",");
        sortMenu(split);
        getMenuCount(split);
        // validationFunction.validateMaxOrderCount 최대주문갯수 검증
        mainCount = countMainForDiscount(menuString);
        dessertCount = countDessertForDiscount(menuString);
        drinkCount = countDrinkForDiscount(menuString);
        epitigerCount = countEpitigerForDiscount(menuString);
        return new MenuCount(mainCount,dessertCount,drinkCount,epitigerCount);
    }

    public void sortMenu(String[] menu) {
        String[] empty = new String[menu.length];
        for (int i = 0; i < menu.length; i++) {
            empty = menu[i].split("-");
            menuString.add(empty[0]);
        }
    }

    public void getMenuCount(String[] menu) {
        String[] empty = new String[menu.length];
        for (int i = 0; i < menu.length; i++) {
            empty = menu[i].split("-");
            menuCountString.add(empty[1]);
        }
    }

    public int countMainForDiscount(List<String> menu) {
        Collection<String> menus = main.keySet();
        int count = 0;
        for (int i = 0; i < menu.size(); i++) {
            if (menus.contains(menu.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countEpitigerForDiscount(List<String> menu) {
        Collection<String> menus = epitiger.keySet();
        int count = 0;
        for (int i = 0; i < menu.size(); i++) {
            if (menus.contains(menu.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countDessertForDiscount(List<String> menu) {
        Collection<String> menus = dessert.keySet();
        int count = 0;
        for (int i = 0; i < menu.size(); i++) {
            if (menus.contains(menu.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countDrinkForDiscount(List<String> menu) {
        Collection<String> menus = drink.keySet();
        int count = 0;
        for (int i = 0; i < menu.size(); i++) {
            if (menus.contains(menu.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void printOrderMenu(String inputMenu) {
        String[] split = inputMenu.split(",");
        sortMenu(split);
        getMenuCount(split);
        for(int i =0; i< split.length;i++){
            System.out.println(menuString.get(i)+" "+menuCountString.get(i)+"개");
        }
    }

}
