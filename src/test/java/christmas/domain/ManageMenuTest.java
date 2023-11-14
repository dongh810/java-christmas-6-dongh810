package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ManageMenuTest {

    @DisplayName("입력받은 메뉴들을 -를 기준으로 분류해서 이름만 가져와서 리스트로 만든다.")
    @Test
    void set_inputMenu_name_list() {
        //given
        ManageMenu manageMenu = new ManageMenu();
        List<String> result = new ArrayList<>();
        String[] inputMenu = {"티본스테이크-1", "제로콜라-2"};
        result.add("티본스테이크");
        result.add("제로콜라");

        //when
        List<String> menu = manageMenu.sortMenu(inputMenu);

        //then
        Assertions.assertThat(menu).isEqualTo(result);
    }

    @DisplayName("입력받은 메뉴들을 -를 기준으로 분류해서 개수만 가져와서 리스트로 만든다.")
    @Test
    void set_inputMenu_count_list() {
        //given
        ManageMenu manageMenu = new ManageMenu();
        List<String> result = new ArrayList<>();
        String[] inputMenu = {"티본스테이크-1", "제로콜라-2"};
        result.add("1");
        result.add("2");

        //when
        List<String> menu = manageMenu.getMenuCount(inputMenu);

        //then
        Assertions.assertThat(menu).isEqualTo(result);
    }

    @DisplayName("처음입력받은 메뉴를 해시맵으로 메뉴이름과 개수로 매칭해서 관리한다.")
    @Test
    void set_hashMap_inputMenu_name_and_count() {
        //given
        ManageMenu manageMenu = new ManageMenu();
        HashMap<String, Integer> result = new HashMap<>();
        String inputMenu = "티본스테이크-1,제로콜라-2";
        result.put("티본스테이크", 1);
        result.put("제로콜라", 2);

        //when
        HashMap<String, Integer> menu = manageMenu.getMenuOrderCount(inputMenu);

        //then
        Assertions.assertThat(menu).isEqualTo(result);
    }

    @DisplayName("할인정보를 계산할때 필요한 총 디저트의 개수를 구한다.")
    @Test
    void get_total_dessert_count() {
        //given
        ManageMenu manageMenu = new ManageMenu();
        String inputMenu = "티본스테이크-1,제로콜라-3,초코케이크-3,아이스크림-1";
        int dessertCount = 0;
        int result = 4;

        //when
        dessertCount = manageMenu.getAllDessertCount(inputMenu);

        //then
        Assertions.assertThat(dessertCount).isEqualTo(result);
    }

    @DisplayName("할인정보를 계산할때 필요한 총 메인메뉴의 개수를 구한다.")
    @Test
    void get_total_main_count() {
        //given
        ManageMenu manageMenu = new ManageMenu();
        String inputMenu = "티본스테이크-1,바비큐립-4,제로콜라-3,초코케이크-3,아이스크림-1";
        int mainCount = 0;
        int result = 5;

        //when
        mainCount = manageMenu.getAllMainCount(inputMenu);

        //then
        Assertions.assertThat(mainCount).isEqualTo(result);
    }
}