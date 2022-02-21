package com.mx.aplazo.simpleinterest.controller;

import com.mx.aplazo.simpleinterest.beans.response.ResponsePayments;
import com.mx.aplazo.simpleinterest.beans.request.PaymentRequest;

import com.mx.aplazo.simpleinterest.bussines.service.CalculateAndGeneratePayment;
import com.mx.aplazo.simpleinterest.bussines.service.SaveReqRespService;
import com.mx.aplazo.simpleinterest.model.entity.RequestResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/health")
public class SimpleInterestController {

    Logger log = LogManager.getLogger(SimpleInterestController.class);

    @Autowired
    CalculateAndGeneratePayment calcPaymentService;

    @Autowired
    SaveReqRespService saveReqRespService;

    @GetMapping(value = "/test")
    public String test(){
        return "Esto es una prueba test";
    }

    @PostMapping(value = "/calculatePayments")
    public ResponseEntity<ResponsePayments> calculatePayments
            (@RequestBody PaymentRequest toPaymentRequest)
    {
        log.info("Request : "+ toPaymentRequest);
        ResponsePayments loResponse  = new ResponsePayments();
        try {
            loResponse = calcPaymentService.callGetPayments(toPaymentRequest);

            return ResponseEntity.status(HttpStatus.OK).body(loResponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(loResponse);
        }
    }

    @GetMapping(value="/getLogs")
    public List<RequestResponse> getLogs() {
        return saveReqRespService.getReqResponse();
    }

}
