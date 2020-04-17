package com.fms.springbatch.excel.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.springbatch.excel.model.OutReachEventsSummary;


@Repository
public interface OutReachEventsSummaryRepository extends MongoRepository<OutReachEventsSummary, BigInteger>{

}
