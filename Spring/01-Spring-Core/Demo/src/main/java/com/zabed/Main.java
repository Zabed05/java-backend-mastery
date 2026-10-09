package com.zabed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    static void main() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Starting a spring container using annotation based configuration

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        PaymentService payment = context.getBean(PaymentService.class);
//        payment.pay();
    }
}
