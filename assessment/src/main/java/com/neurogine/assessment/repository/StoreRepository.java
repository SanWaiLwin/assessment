package com.neurogine.assessment.repository;
 
import org.springframework.data.mongodb.repository.MongoRepository;

import com.neurogine.assessment.model.Store;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 2:31:32 PM
 */
public interface StoreRepository extends MongoRepository<Store, String>{

}
