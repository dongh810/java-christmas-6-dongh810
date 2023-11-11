package christmas.constant;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    public List<Integer> setWeekDay() {
        List<Integer> weekday = new ArrayList<>();
        Integer[] weekdayNumber = {4,5,6,7,11,12,13,14,18,19,20,21,26,27,28};
        for(int i=0;i< weekdayNumber.length;i++){
            weekday.add(weekdayNumber[i]);
        }
        return weekday;
    }

    public List<Integer> setWeekend() {
        List<Integer> weekend = new ArrayList<>();
        Integer[] weekendNumber = {1,2,8,9,15,16,22,23,29,30};
        for(int i=0;i< weekendNumber.length;i++){
            weekend.add(weekendNumber[i]);
        }
        return weekend;
    }

    public List<Integer> setSpecialDay() {
        List<Integer> specialDay = new ArrayList<>();
        Integer[] specialDayNumber = {3,10,17,24,25,31};
        for(int i=0;i< specialDayNumber.length;i++){
            specialDay.add(specialDayNumber[i]);
        }
        return specialDay;
    }
}
