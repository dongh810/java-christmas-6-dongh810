package christmas.constant;

import java.util.HashMap;

public class Menu {

    public HashMap<String, Integer> setEpitiger() {
        HashMap<String, Integer> epitiger = new HashMap<String, Integer>();
        epitiger.put("양송이수프", 6000);
        epitiger.put("타파스", 5500);
        epitiger.put("시저샐러드", 8000);

        return epitiger;
    }

    public HashMap<String, Integer> setMain() {
        HashMap<String, Integer> main = new HashMap<String, Integer>();
        main.put("티본스테이크", 55000);
        main.put("바비큐립", 54000);
        main.put("해산물파스타", 35000);
        main.put("크리스마스파스타", 25000);

        return main;
    }

    public HashMap<String, Integer> setDessert() {
        HashMap<String, Integer> dessert = new HashMap<String, Integer>();
        dessert.put("초코케이크", 15000);
        dessert.put("아이스크림", 5000);

        return dessert;
    }

    public HashMap<String, Integer> setDrink() {
        HashMap<String, Integer> drink = new HashMap<String, Integer>();
        drink.put("제로콜라", 3000);
        drink.put("레드와인", 60000);
        drink.put("샴페인", 25000);

        return drink;
    }

    public HashMap<String, Integer> setAllMenu() {
        HashMap<String, Integer> allMenu = new HashMap<String, Integer>();
        allMenu.put("양송이수프", 6000);
        allMenu.put("타파스", 5500);
        allMenu.put("시저샐러드", 8000);
        allMenu.put("티본스테이크", 55000);
        allMenu.put("바비큐립", 54000);
        allMenu.put("해산물파스타", 35000);
        allMenu.put("크리스마스파스타", 25000);
        allMenu.put("초코케이크", 15000);
        allMenu.put("아이스크림", 5000);
        allMenu.put("제로콜라", 3000);
        allMenu.put("레드와인", 60000);
        allMenu.put("샴페인", 25000);

        return allMenu;
    }
}
