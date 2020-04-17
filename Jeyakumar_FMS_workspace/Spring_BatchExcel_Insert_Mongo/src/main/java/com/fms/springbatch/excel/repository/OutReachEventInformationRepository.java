package com.fms.springbatch.excel.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fms.springbatch.excel.model.OutReachEventInformation;

@Repository
public interface OutReachEventInformationRepository extends MongoRepository<OutReachEventInformation,BigInteger> {

}
