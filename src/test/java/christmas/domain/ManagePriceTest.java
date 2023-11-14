package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class ManagePriceTest {

    @DisplayName("음식값이 있는 해시맵을 가격과 개수를 곱해 전체 가격을 구한다.")
    @Test
    void add_all_menu_cost() {
        ManagePrice managePrice = new ManagePrice();
        int totalPrice = 58000;
        int result = managePrice.getTotalPrice("티본스테이크-1,제로콜라-1");
        Assertions.assertThat(result).isEqualTo(totalPrice);
    }

    @DisplayName("음식의 이름에 따른 가격을 음식의 개수와 함께 가져와서 해시맵으로 받아온다.")
    @Test
    void get_cost_and_menu_count() {
        ManagePrice managePrice = new ManagePrice();
        HashMap<Integer, Integer> priceWithCount = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(55000, 1);
        result.put(3000, 1);
        priceWithCount = managePrice.getMenuPrice("티본스테이크-1,제로콜라-1");
        Assertions.assertThat(priceWithCount).isEqualTo(result);
    }
}