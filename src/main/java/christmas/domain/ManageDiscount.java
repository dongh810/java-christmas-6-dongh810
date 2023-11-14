package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class ManageDiscount {

    ManageMenu manageMenu = new ManageMenu();

    public List<Integer> setAllDiscount(int divisionNum, String inputMenu) {
        int dessertNumber = manageMenu.getAllDessertCount(inputMenu);
        int mainNumber = manageMenu.getAllMainCount(inputMenu);
        List<Integer> allDiscount = divisionNumCondition(dessertNumber, mainNumber, divisionNum);
        return allDiscount;
    }

    private List<Integer> divisionNumCondition(int dessertNum, int mainNum, int divisionNum) {
        List<Integer> discount = new ArrayList<>();
        if (divisionNum == 1) {
            discount = firstDivision(dessertNum);
        }
        if (divisionNum == 2) {
            discount = secondDivision(mainNum);
        }
        if (divisionNum == 3) {
            discount = thirdDivision(dessertNum);
        }
        return discount;
    }

    private List<Integer> firstDivision(int dessertNum) {
        List<Integer> discount = new ArrayList<>();
        Integer weekdayDiscount = 0;
        weekdayDiscount += dessertNum * 2023;
        discount.add(weekdayDiscount);
        return discount;
    }

    private List<Integer> secondDivision(int mainNum) {
        List<Integer> discount = new ArrayList<>();
        Integer weekendDiscount = 0;
        weekendDiscount += mainNum * 2023;
        discount.add(weekendDiscount);
        return discount;
    }

    private List<Integer> thirdDivision(int dessertNum) {
        List<Integer> discount = new ArrayList<>();
        Integer specialDiscount = 0;
        Integer weekdayDiscount = 0;
        weekdayDiscount += dessertNum * 2023;
        specialDiscount += 1000;
        discount.add(weekdayDiscount);
        discount.add(specialDiscount);
        return discount;
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
        int dayDiscount = getDayDiscount(day);
        int totalDiscount = 0;
        for (int i = 0; i < discount.size(); i++) {
            totalDiscount += discount.get(i);
        }
        totalDiscount += dayDiscount;
        return totalDiscount;
    }
}
