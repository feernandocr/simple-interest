package com.mx.aplazo.simpleinterest.bussines.service;

import com.mx.aplazo.simpleinterest.model.entity.RequestResponse;

import java.util.List;

public interface SaveReqRespService {

    public List<RequestResponse> getReqResponse();

    public void saveReqResponse(RequestResponse toEntity);

}
