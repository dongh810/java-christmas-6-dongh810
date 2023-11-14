package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManageBedgeTest {

    @DisplayName("총 할인금액에 따라 뱃지를 다르게 출력한다.")
    @Test
    void check_printBedge_by_totalDiscount() {
        //given
        ManageBedge manageBedge = new ManageBedge();

        //when
        String bedge = manageBedge.getBedge(3, "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", 24);

        //then
        Assertions.assertThat(bedge).isEqualTo("산타");

    }
}