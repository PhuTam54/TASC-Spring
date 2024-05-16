package com.example.demospring;

import com.example.demospring.service.impl.PrototypeBean;
import com.example.demospring.service.impl.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(DemoSpringApplication.class, args);
        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean1.hashCode());
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean2.hashCode());

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.hashCode());
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.hashCode());

//        Color red = new Red();
//        Phone phone = new Phone(red);
    }
}
