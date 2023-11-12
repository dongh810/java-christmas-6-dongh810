package christmas.domain;

import christmas.constant.Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ManageMenu {

    Menu menu = new Menu();
    HashMap<String, Integer> main = menu.setMain();
    HashMap<String, Integer> dessert = menu.setDessert();

    public void validateMaxOrderCount(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> menuString = sortMenu(split);
        List<String> menuCountString = getMenuCount(split);
        int allMenuCount = 0;
        for (int i = 0; i < menuCountString.size(); i++) {
            allMenuCount += Integer.parseInt(menuCountString.get(i));
        }
        // validationFunction.validateMaxOrderCount 최대주문갯수 검증
    }

    public List<String> sortMenu(String[] menu) {
        String[] empty = new String[menu.length];
        List<String> menuString = new ArrayList<>();
        for (int i = 0; i < menu.length; i++) {
            empty = menu[i].split("-");
            menuString.add(empty[0]);
        }
        return menuString;
    }

    public List<String> getMenuCount(String[] menu) {
        String[] empty = new String[menu.length];
        List<String> menuCountString = new ArrayList<>();
        for (int i = 0; i < menu.length; i++) {
            empty = menu[i].split("-");
            menuCountString.add(empty[1]);
        }
        return menuCountString;
    }

    public List<String> printOrderMenu(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> menuString = sortMenu(split);
        List<String> menuCountString = getMenuCount(split);
        List<String> orderMenu = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            orderMenu.add(String.format("%s %s개", menuString.get(i), menuCountString.get(i)));
        }
        return orderMenu;
    }

    public HashMap<String, Integer> getMenuOrderCount(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> menuString = sortMenu(split);
        List<String> menuCountString = getMenuCount(split);
        HashMap<String, Integer> menuOrderCount = new HashMap<String, Integer>();
        for (int i = 0; i < split.length; i++) {
            menuOrderCount.put(menuString.get(i), Integer.parseInt(menuCountString.get(i)));
        }
        return menuOrderCount;
    }

    public int getAllDessertCount(String inputMenu) {
        HashMap<String, Integer> menuOrderCount = getMenuOrderCount(inputMenu);
        String[] split = inputMenu.split(",");
        List<String> menuString = sortMenu(split);
        Collection<String> menus = dessert.keySet();
        int dessertAllCount = 0;
        for (int i = 0; i < menuString.size(); i++) {
            if (menus.contains(menuString.get(i))) {
                dessertAllCount += menuOrderCount.get(menuString.get(i));
            }
        }
        return dessertAllCount;
    }

    public int getAllMainCount(String inputMenu) {
        HashMap<String, Integer> menuOrderCount = getMenuOrderCount(inputMenu);
        String[] split = inputMenu.split(",");
        List<String> menuString = sortMenu(split);
        Collection<String> menus = main.keySet();
        int mainAllCount = 0;
        for (int i = 0; i < menuString.size(); i++) {
            if (menus.contains(menuString.get(i))) {
                mainAllCount += menuOrderCount.get(menuString.get(i));
            }
        }
        return mainAllCount;
    }
}
