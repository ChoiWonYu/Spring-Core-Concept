package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test()
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinition=ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinition)
                .forEach(b->{
                    Object bean=ac.getBean(b);
                    System.out.println("name = " + b + "object = "+bean);
                });
    }


    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionName=ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionName)
                //Role ROLE_APPLICATION : 직접 등록한 어플리케이션 빈
                //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
                .filter(b->{
                    BeanDefinition beanDefinition=ac.getBeanDefinition(b);
                    return beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION;
                })
                .forEach(n->{
                    Object bean=ac.getBean(n);
                    System.out.println("name = " + n + "object = "+bean);
                });
    }
}
