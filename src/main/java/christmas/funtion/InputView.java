package christmas.funtion;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    ValidationFunction validationFunction = new ValidationFunction();

    public int readDate() {
        String getDate = Console.readLine();
        validationFunction.validateDateNumber(getDate);
        int date = Integer.parseInt(getDate);
        validationFunction.validateDateRange(date);
        return date;
    }

    public String readMenu() {
        String getMenu = Console.readLine();
        validationFunction.validateAllOrderCondition(getMenu);
        return getMenu;
    }
}
