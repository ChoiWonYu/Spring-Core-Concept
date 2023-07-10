package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberServiceImpl memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderServiceImpl orderService(){
       return  new OrderServiceImpl(new MemoryMemberRepository(),new RateDiscountPolicy());
    }
}
