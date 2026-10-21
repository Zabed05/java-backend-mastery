package com.zabed.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier()    // we also can change the name of bean, like: @Qualifier("cp")
public class CardPayment implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Paying by Card");
    }
}