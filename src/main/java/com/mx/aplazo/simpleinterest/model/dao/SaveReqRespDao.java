package com.mx.aplazo.simpleinterest.model.dao;

import com.mx.aplazo.simpleinterest.model.entity.RequestResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveReqRespDao extends CrudRepository<RequestResponse, Long> {
}
