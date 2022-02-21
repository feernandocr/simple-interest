package com.mx.aplazo.simpleinterest.beans.response;

import java.util.Date;

public class Payment {
    private Integer payment_number;
    private Double amount;
    private Date payment_date;

    public Payment(Integer payment_number, Double amount, Date payment_date) {
        this.payment_number = payment_number;
        this.amount = amount;
        this.payment_date = payment_date;
    }

    public Integer getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(Integer payment_number) {
        this.payment_number = payment_number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_number=" + payment_number +
                ", amount=" + amount +
                ", payment_date=" + payment_date +
                '}';
    }
}
