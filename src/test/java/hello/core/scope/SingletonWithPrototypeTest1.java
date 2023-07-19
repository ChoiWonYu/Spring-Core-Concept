package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {
  @Test
  public void prototypeFind(){
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);
    ClientBean client1 = ac.getBean(ClientBean.class);
    int count1 = client1.logic();
    assertThat(count1).isEqualTo(1);

    ClientBean client2 = ac.getBean(ClientBean.class);
    int count2 = client2.logic();
    assertThat(count2).isEqualTo(2);

  }

  @Scope("singleton")
  @RequiredArgsConstructor
  static class ClientBean{
    private final PrototypeBean prototypeBean;

    public int logic() {
      prototypeBean.addCount();
      return prototypeBean.getCount();
    }

  }

  @Scope("prototype")
  @Getter
  static class PrototypeBean{
    public int count=0;

    public void addCount() {
      count++;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init"+this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }
}
