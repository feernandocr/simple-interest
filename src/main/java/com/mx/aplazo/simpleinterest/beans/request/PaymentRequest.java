package com.mx.aplazo.simpleinterest.beans.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest {

    @JsonProperty("amount")
    private Double pdAmount;
    @JsonProperty("terms")
    private Integer pdTerms;
    @JsonProperty("rate")
    private Double piRate;

    public Double getAmount() {
        return pdAmount;
    }

    public void setAmount(Double pdAmount) {
        this.pdAmount = pdAmount;
    }

    public Integer getTerms() {
        return pdTerms;
    }

    public void setTerms(Integer pdTerms) {
        this.pdTerms = pdTerms;
    }

    public Double getRate() {
        return piRate;
    }

    public void setRate(Double piRate) {
        this.piRate = piRate;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "pdAmount=" + pdAmount +
                ", pdTerms=" + pdTerms +
                ", piRate=" + piRate +
                '}';
    }
}
