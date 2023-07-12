package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService service1=ac.getBean(StatefulService.class);
        StatefulService service2=ac.getBean(StatefulService.class);

        service1.order("Client1",10000);
        service2.order("Client1",20000);

        int price=service1.getPrice();

        System.out.println("price = "+price);

        Assertions.assertThat(price).isEqualTo(20000);
    }



    @Configuration
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }


}



