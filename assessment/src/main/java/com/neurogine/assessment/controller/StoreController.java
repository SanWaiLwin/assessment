package com.neurogine.assessment.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assessment.common.CommonConstants;
import com.neurogine.assessment.config.IntegrationConfig.CreateStoreGateway;
import com.neurogine.assessment.config.IntegrationConfig.DeleteStoreGateway;
import com.neurogine.assessment.config.IntegrationConfig.GetStoreListGateway;
import com.neurogine.assessment.config.IntegrationConfig.UpdateStoreGateway;
import com.neurogine.assessment.request.CreateStoreRequest;
import com.neurogine.assessment.request.DeleteStoreRequest;
import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.request.UpdateStoreRequest;
import com.neurogine.assessment.response.StoreListResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 11:29:59 AM
 */
@RestController
@RequestMapping("/api/stores")
public class StoreController {

	private final GetStoreListGateway getStoreListGateway;
	private final CreateStoreGateway createStoreGateway;
	private final UpdateStoreGateway updateStoreGateway;
	private final DeleteStoreGateway deleteStoreGateway;

	public StoreController(GetStoreListGateway getStoreListGateway, CreateStoreGateway createStoreGateway,
			UpdateStoreGateway updateStoreGateway, DeleteStoreGateway deleteStoreGateway) {
		this.getStoreListGateway = getStoreListGateway;
		this.createStoreGateway = createStoreGateway;
		this.updateStoreGateway = updateStoreGateway;
		this.deleteStoreGateway = deleteStoreGateway;
	}

	@PostMapping("/getStoreList")
	public ResponseEntity<StoreListResponse> getStoreList(@Valid @RequestBody StoreListRequest request) {
		StoreListResponse response = getStoreListGateway.getStoreList(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/createStore")
	public ResponseEntity<String> createStore(@Valid @RequestBody CreateStoreRequest request) {
		createStoreGateway.createStore(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonConstants.STORE_CREATE_SUCCESS_MSG);
	}

	@PostMapping("/updateStore")
	public ResponseEntity<String> updateStore(@Valid @RequestBody UpdateStoreRequest request) {
		updateStoreGateway.updateStore(request);
		return ResponseEntity.status(HttpStatus.OK).body(CommonConstants.STORE_UPDATE_SUCCESS_MSG);
	}

	@DeleteMapping("/deleteStore")
	public ResponseEntity<String> deleteStore(@Valid @RequestBody DeleteStoreRequest request) {
		deleteStoreGateway.deleteStore(request);
		return ResponseEntity.status(HttpStatus.OK).body(CommonConstants.STORE_DELETE_SUCCESS_MSG);
	} 

}
