package com.zabed;

import com.zabed.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    @Autowired // it means OrderService has a dependency i.e. PaymentService, inject that dependency via constructor
    public OrderService(@Qualifier("cardPayment") PaymentService paymentService){ // here we tell that take the cardPayment object
        this.paymentService = paymentService;
    }

//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){

        paymentService.pay();

        System.out.println("Order Successful");
    }
}
