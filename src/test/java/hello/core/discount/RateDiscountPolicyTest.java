package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


    RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_O(){
        Member member=new Member(1L,"memberA", Grade.VIP);
        int discountPrice=rateDiscountPolicy.discount(member,10000);

        assertThat(discountPrice).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되면 안 된다.")
    void vip_x(){
        Member member=new Member(2L,"memberB", Grade.BASIC);
        int discountPrice=rateDiscountPolicy.discount(member,10000);

        assertThat(discountPrice).isEqualTo(0);

    }


}