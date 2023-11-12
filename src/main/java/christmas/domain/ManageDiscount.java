package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class ManageDiscount {

    ManageMenu manageMenu = new ManageMenu();

    public List<Integer> setAllDiscount(int divisionNum, String inputMenu) {
        int dessertNumber = manageMenu.getAllDessertCount(inputMenu);
        int mainNumber = manageMenu.getAllMainCount(inputMenu);
        Integer weekdayDiscount = 0;
        Integer weekendDiscount = 0;
        Integer specialDiscount = 0;
        List<Integer> allDiscount = new ArrayList<>();
        if (divisionNum == 1) {
            weekdayDiscount += dessertNumber * 2023;
            allDiscount.add(weekdayDiscount);
        }
        if (divisionNum == 2) {
            weekendDiscount += mainNumber * 2023;
            allDiscount.add(weekendDiscount);
        }
        if (divisionNum == 3) {
            weekdayDiscount += dessertNumber * 2023;
            specialDiscount += 1000;
            allDiscount.add(weekdayDiscount);
            allDiscount.add(specialDiscount);
        }
        return allDiscount;
    }

    public int getDayDiscount(int day) {
        int dayDiscount = 1000;
        if (day <= 25) {
            for (int i = 1; i < day; i++) {
                dayDiscount += 100;
            }
        }
        if (day > 25) {
            dayDiscount = 0;
        }
        return dayDiscount;
    }

    public List<Integer> getAllDiscount(int divisionNum, String inputMenu, int day) {
        List<Integer> allDiscount = setAllDiscount(divisionNum, inputMenu);
        if (allDiscount.size() == 1) {
            if (allDiscount.get(0) == 0) {
                allDiscount.clear();
            }
        }
        if (allDiscount.size() == 2) {
            if (allDiscount.get(0) == 0 && allDiscount.get(1) == 0) {
                allDiscount.clear();
            }
        }
        return allDiscount;
    }

    public int getTotalDiscount(int divisionNum, String inputMenu, int day) {
        List<Integer> discount = getAllDiscount(divisionNum, inputMenu, day);
        int totalDiscount = 0;
        for (int i = 0; i < discount.size(); i++) {
            totalDiscount += discount.get(i);
        }
        return totalDiscount;
    }
}
