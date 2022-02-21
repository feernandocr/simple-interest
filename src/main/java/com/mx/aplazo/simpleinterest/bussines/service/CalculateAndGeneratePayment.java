package com.mx.aplazo.simpleinterest.bussines.service;

import com.mx.aplazo.simpleinterest.beans.request.PaymentRequest;
import com.mx.aplazo.simpleinterest.beans.response.ResponsePayments;


public interface CalculateAndGeneratePayment {

    public ResponsePayments callGetPayments(PaymentRequest toPayment);

}
