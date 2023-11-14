package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ManageDiscountTest {

    @DisplayName("할인에 관한 날짜 구분숫자와 메뉴를 받아서 그날 받을 수 있는 모든 할인정보를 가져온다.")
    @Test
    void calculate_all_discount() {
        //given
        ManageDiscount manageDiscount = new ManageDiscount();
        List<Integer> allDiscount = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(4046);
        result.add(1000);

        //when
        allDiscount = manageDiscount.setAllDiscount(3, "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        //then
        Assertions.assertThat(allDiscount).isEqualTo(result);
    }

    @DisplayName("25일까지 하루에 100원씩 올라가는 할인금액을 구한다.")
    @Test
    void calculate_christmas_discount() {
        //given
        ManageDiscount manageDiscount = new ManageDiscount();

        //when
        int discount = manageDiscount.getDayDiscount(3);

        //then
        Assertions.assertThat(discount).isEqualTo(1200);
    }

}