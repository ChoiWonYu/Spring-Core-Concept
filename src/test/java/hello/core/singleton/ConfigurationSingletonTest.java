package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class ConfigurationSingletonTest {
    @Test
    void ConfigurationTest(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",
                MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",
                OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",
                MemberRepository.class);

        System.out.println("memberService -> memberRepository = " +
                memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = " +
                orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberRepository).isSameAs(memberService.getMemberRepository());
        Assertions.assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    }

    @Test
    void configuration(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean=ac.getBean(AppConfig.class);

        MemberRepository memberRepository = ac.getBean("memberRepository",
                MemberRepository.class);

        System.out.println("bean = "+bean.getClass());
        System.out.println("memberRepository = "+memberRepository.getClass());

    }

}
