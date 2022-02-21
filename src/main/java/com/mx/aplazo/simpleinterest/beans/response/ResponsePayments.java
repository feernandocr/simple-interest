package com.mx.aplazo.simpleinterest.beans.response;

import com.mx.aplazo.simpleinterest.beans.response.Payment;

import java.util.ArrayList;
import java.util.List;


public class ResponsePayments {
    private List<Payment> loPayments;

    public List<Payment> getLoPayments() {
        if (loPayments == null){
            loPayments = new ArrayList<Payment>();
        }
        return loPayments;
    }

    public void setLoPayments(List<Payment> loPayments) {
        this.loPayments = loPayments;
    }

    @Override
    public String toString() {
        return "ResponsePayments{" +
                "loPayments=" + loPayments +
                '}';
    }
}
