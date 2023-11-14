package christmas.funtion;

import christmas.constant.ErrorMessage;
import christmas.constant.Menu;
import christmas.domain.ManageMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class ValidationFunctionTest {

    ManageMenu manageMenu = new ManageMenu();
    ValidationFunction validationFunction = new ValidationFunction();
    Menu menu = new Menu();
    HashMap<String, Integer> main = menu.setMain();
    HashMap<String, Integer> dessert = menu.setDessert();
    HashMap<String, Integer> epitiger = menu.setEpitiger();
    HashMap<String, Integer> allMenu = menu.setAllMenu();


    @DisplayName("날짜입력받을때 숫자말고 다른걸 입력했을때 오류가 뜨도록 검증")
    @Test
    void validateDateNumberTest() {
        String input = "[";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateDateNumber(input);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_DATE);
    }

    @DisplayName("날짜입력받을때 숫자범위가 벗어나게 입력했을때 오류가 뜨도록 검증")
    @Test
    void validateDateRangeTest() {
        int input = 50;
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateDateRange(input);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_DATE);
    }

    @DisplayName("음료수만 주문했을때 주문이 안되도록 검증")
    @Test
    void validateOrderOnlyDrinkTest() {
        String inputMenu = "제로콜라-1";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateOrderOnlyDrink(inputMenu);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_ONLY_DRINK);
    }

    @DisplayName("총 주문 음식의 개수가 20개가 넘어가지 않도록 검증")
    @Test
    void validateOrderCountLimitTest() {
        String inputMenu = "제로콜라-12,티본스테이크-20";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateOrderCountLimit(inputMenu);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MENU_ORDER_LIMIT);
    }

    @DisplayName("메뉴판에 없는 메뉴를 주문하지 못하도록 검증")
    @Test
    void validateOrderInMenuTest() {
        String inputMenu = "토마토파스타-3";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateOrderInMenu(inputMenu);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_ORDER);
    }

    @DisplayName("0개를 주문하지 못하도록 검증")
    @Test
    void validateOrderZeroTest() {
        String inputMenu = "티본스테이크-0";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateOrderZero(inputMenu);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_ORDER);
    }

    @DisplayName("주문형식을 맞춰서 주문 할 수 있도록 검증")
    @Test
    void validateOrderRuleTest() {
        String inputMenu = "티본스테이크(2),제로콜라-3";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateOrderRule(inputMenu);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_ORDER);
    }

    @DisplayName("중복메뉴를 입력하지 못하도록 검증")
    @Test
    void validateDistinctMenuTest() {
        String inputMenu = "티본스테이크-2,제로콜라-3,티본스테이크-1";
        Assertions.assertThatThrownBy(() -> {
                    validationFunction.validateDistinctMenu(inputMenu);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_ORDER);
    }
}