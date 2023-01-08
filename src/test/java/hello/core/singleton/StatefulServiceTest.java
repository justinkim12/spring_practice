package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void satefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        int userAPrice = statefulService1.order("userA",10000);
        System.out.println("userAPrice = " + userAPrice);
        //ThreadB : B 사용자 20000원 주문
//        statefulService2.order("userB",20000);

        //ThreadA : A 사용자 금액 조회
        //int price = statefulService1.getPrice();

        //20000원 나와버림!
//        assertThat(userAPrice).isEqualTo(20000);


    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}