package com.mx.aplazo.simpleinterest.bussines.service;

import com.mx.aplazo.simpleinterest.beans.request.PaymentRequest;
import com.mx.aplazo.simpleinterest.beans.response.Payment;
import com.mx.aplazo.simpleinterest.beans.response.ResponsePayments;

import com.mx.aplazo.simpleinterest.model.entity.RequestResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalculateAndGeneratePaymentImpl implements CalculateAndGeneratePayment
{

    Logger log = LogManager.getLogger(CalculateAndGeneratePaymentImpl.class);

    @Autowired
    SaveReqRespService saveReqRespService;

    @Override
    public ResponsePayments callGetPayments(PaymentRequest toPayment) {

        double liRate = toPayment.getRate();
        double ldAmount = toPayment.getAmount();
        int liTermns = toPayment.getTerms();
        double ldPreInterest = 0.00;
        double ldTotal = 0.00;
        double ldMontoPago = 0.00;
        List<Payment> loPayments = new ArrayList<>();
        ResponsePayments loResponse = new ResponsePayments();
        RequestResponse loEntityLog = new RequestResponse();

        /*1.-Calcular el interes del temino y sumarlo a la cantidad solicitada */
        ldPreInterest = ldAmount * liRate;
        ldTotal = (ldPreInterest / 100) + ldAmount;
        log.info("Total a pagar : " + ldTotal);
        /* 2.- Diferir el total a pagar en 5 plazos */
        ldMontoPago = ldTotal / liTermns;
        log.info("Monto de Pago : " + ldMontoPago);

        long pivotDays = 0;
        LocalDate ldLocalDate = LocalDate.now();
        Date ldPaymentDate = new Date();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        String pattern = "EEEEE MMMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        for (int i = 1; i <= liTermns; i++) {

            ldLocalDate   = ldLocalDate.plusDays(pivotDays);
            ldPaymentDate = Date.from(ldLocalDate.atStartOfDay(defaultZoneId).toInstant());

            loPayments.add(new Payment(i, ldMontoPago, ldPaymentDate));

            pivotDays+=5;
        }

        loResponse.setLoPayments(loPayments);
        /*Wrapper to entity*/
        loEntityLog.setRequest(toPayment.toString());
        loEntityLog.setResponse(loResponse.toString());
        loEntityLog.getCreationDate(Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()));

        saveReqRespService.saveReqResponse(loEntityLog);
        return loResponse;
    }
}

