package com.app.services;

import com.app.dtos.PaymentCallback;
import com.app.dtos.PaymentDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentService {
    public void processPayment();

    String payuCallback(PaymentCallback paymentCallback);

    PaymentDetail proceedPayment(PaymentDetail paymentDetail);
}