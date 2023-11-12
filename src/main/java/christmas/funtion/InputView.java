package christmas.funtion;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        String getDate = Console.readLine();
        int date = Integer.parseInt(getDate);
        return date;
    }

    public String readMenu() {
        String getMenu = Console.readLine();
        return getMenu;
    }
}
