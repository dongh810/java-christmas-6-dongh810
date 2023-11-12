package christmas.domain;

import christmas.constant.Calendar;

import java.util.List;

public class ManageCalendar {

    Calendar calendar = new Calendar();
    List<Integer> weekday = calendar.setWeekDay();
    List<Integer> weekend = calendar.setWeekend();
    List<Integer> specialDay = calendar.setSpecialDay();

    public int getDate(int day) {
        int visitDay = day;
        if (weekday.contains(visitDay)) {
            return 1;
        }
        if (weekend.contains(visitDay)) {
            return 2;
        }
        if (specialDay.contains(visitDay)) {
            return 3;
        }
        return 0;
    }
}
