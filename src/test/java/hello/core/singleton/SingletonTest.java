package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void PureContainer(){
        AppConfig appConfig=new AppConfig();

        //첫 번째 요청 객체 생성
        MemberService memberService1=appConfig.memberService();

        //두 번째 요청 객체 생성
        MemberService memberService2=appConfig.memberService();

        //서로 참조값이 다르다
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }


}
