package christmas.funtion;

import christmas.constant.ErrorMessage;
import christmas.constant.Menu;
import christmas.domain.ManageMenu;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationFunction {

    ManageMenu manageMenu = new ManageMenu();
    Menu menu = new Menu();
    HashMap<String, Integer> main = menu.setMain();
    HashMap<String, Integer> dessert = menu.setDessert();
    HashMap<String, Integer> epitiger = menu.setEpitiger();
    HashMap<String, Integer> allMenu = menu.setAllMenu();

    public void validateAllOrderCondition(String inputMenu) {
        validateOrderInMenu(inputMenu);
        validateOrderZero(inputMenu);
        validateOrderRule(inputMenu);
        validateDistinctMenu(inputMenu);
        validateOrderCountLimit(inputMenu);
        validateOrderOnlyDrink(inputMenu);
    }

    public void validateDateNumber(String inputDay) {
        String pattern = "^[0-9]*$";
        boolean regex = Pattern.matches(pattern, inputDay);
        if (regex == false) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DATE);
        }
    }

    public void validateDateRange(int inputDay) {
        int day = inputDay;
        if (day > 31 || day < 1) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_DATE);
        }
    }

    public void validateOrderOnlyDrink(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> allOrderMenu = manageMenu.sortMenu(split);
        int checknum = 0;
        for (int i = 0; i < allOrderMenu.size(); i++) {
            if (main.containsKey(allOrderMenu.get(i)) || dessert.containsKey(allOrderMenu.get(i)) || epitiger.containsKey(allOrderMenu.get(i))) {
                checknum = 1;
            }
        }
        if (checknum == 0) {
            throw new IllegalArgumentException(ErrorMessage.NO_ONLY_DRINK);
        }
    }

    public void validateOrderCountLimit(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> menuCount = manageMenu.getMenuCount(split);
        int totalCount = 0;
        for (int i = 0; i < menuCount.size(); i++) {
            totalCount += Integer.parseInt(menuCount.get(i));
        }
        if (totalCount >= 20) {
            throw new IllegalArgumentException(ErrorMessage.MENU_ORDER_LIMIT);
        }
    }

    public void validateOrderInMenu(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> allOrderMenu = manageMenu.sortMenu(split);
        int weirdMenu = 0;
        for (int i = 0; i < allOrderMenu.size(); i++) {
            if (allMenu.containsKey(allOrderMenu.get(i))) {
                weirdMenu = 1;
            }
        }
        if (weirdMenu == 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER);
        }
    }

    public void validateOrderZero(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> menuCount = manageMenu.getMenuCount(split);
        if (menuCount.contains("0")) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER);
        }
    }

    public void validateOrderRule(String inputMenu) {
        String[] split = inputMenu.split(",");
        String pattern = "^[가-힣]*\\-\\d{1,2}";
        for (int i = 0; i < split.length; i++) {
            boolean regex = Pattern.matches(pattern, split[i]);
            if (regex == false) {
                throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER);
            }
        }
    }

    public void validateDistinctMenu(String inputMenu) {
        String[] split = inputMenu.split(",");
        List<String> allOrderMenu = manageMenu.sortMenu(split);
        if (allOrderMenu.size() != allOrderMenu.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER);
        }
    }
}
