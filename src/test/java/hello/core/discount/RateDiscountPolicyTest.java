package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy dicsountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인")
    void vip_o(){
        Member member = new Member(1L, "memberVip", Grade.VIP);
        int discount = dicsountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
    }
//성공 테스트 케이스

//    @Test
//    @DisplayName("Vip 아니면 할인 X")
//    void vip_x(){
//        Member member = new Member(1L, "memberVip", Grade.BASIC);
//        int discount = dicsountPolicy.discount(member,10000);
//        assertThat(discount).isEqualTo(1000);
//    }
//실패한 테스트 케이스

}