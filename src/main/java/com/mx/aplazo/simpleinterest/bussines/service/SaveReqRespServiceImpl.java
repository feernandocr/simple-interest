package com.mx.aplazo.simpleinterest.bussines.service;

import com.mx.aplazo.simpleinterest.model.dao.SaveReqRespDao;
import com.mx.aplazo.simpleinterest.model.entity.RequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveReqRespServiceImpl implements SaveReqRespService {

    @Autowired
    private SaveReqRespDao saveReqRespDao;

    @Override
    public List<RequestResponse> getReqResponse() {
        return (List<RequestResponse>) saveReqRespDao.findAll();
    }

    @Override
    public void saveReqResponse(RequestResponse toEntity) {
        saveReqRespDao.save(toEntity);
    }
}
