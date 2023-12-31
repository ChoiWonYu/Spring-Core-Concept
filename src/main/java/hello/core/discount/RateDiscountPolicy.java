package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountRate=10;
    @Override
    public int discount(Member member, int price) {
        return member.getGrade()== Grade.VIP?discountRate*price/100:0;
    }
}
