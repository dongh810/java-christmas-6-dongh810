package christmas.domain;

import christmas.constant.Calendar;
import christmas.constant.MenuCount;

import java.util.List;

public class ManageDiscount {

    Calendar calendar = new Calendar();
    ManageMenu manageMenu = new ManageMenu();
    List<Integer> weekday = calendar.setWeekDay();
    List<Integer> weekend = calendar.setWeekend();
    List<Integer> specialDay = calendar.setSpecialDay();
    Integer discount = 0;

    public void getDiscount(int divisionNum,String inputMenu) {
        MenuCount menuCount = manageMenu.countEachMenuForDiscount(inputMenu);
        int dessertNumber = menuCount.dessertCount; // 디저트개수 가져와야함
        int mainNumber = menuCount.mainCount; //메인개수 가져와야함
        if(divisionNum == 1){
             discount += dessertNumber * 2023;
        }
        if(divisionNum == 2) {
             discount += mainNumber * 2023;
        }
        if(divisionNum == 3) {
            discount += 1000;
        }
    }

    public int getDayDiscount(int day) {
        int dayDiscount = 1000;
        if(day<=25){
            for(int i =1; i<day+1 ; i++){
                dayDiscount += 100;
            }
        }
        if(day>25){
            dayDiscount = 0;
        }
        return dayDiscount;
    }


}
