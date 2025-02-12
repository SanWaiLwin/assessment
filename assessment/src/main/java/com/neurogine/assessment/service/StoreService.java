package com.neurogine.assessment.service;

import com.neurogine.assessment.request.CreateStoreRequest;
import com.neurogine.assessment.request.DeleteStoreRequest;
import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.request.UpdateStoreRequest;
import com.neurogine.assessment.response.StoreListResponse;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 12:16:26 PM
 */
public interface StoreService {

	StoreListResponse getStoreList(StoreListRequest request);

	void createStore(CreateStoreRequest request);

	void updateStore(UpdateStoreRequest request);

	void deleteStore(DeleteStoreRequest request);

}
