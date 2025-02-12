package com.neurogine.assessment.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neurogine.assessment.dto.StoreDTO;
import com.neurogine.assessment.exception.EntityNotFoundException;
import com.neurogine.assessment.model.Store;
import com.neurogine.assessment.model.Store.Discount;
import com.neurogine.assessment.repository.StoreRepository;
import com.neurogine.assessment.request.CreateStoreRequest;
import com.neurogine.assessment.request.DeleteStoreRequest;
import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.request.UpdateStoreRequest;
import com.neurogine.assessment.response.StoreListResponse;
import com.neurogine.assessment.service.StoreService;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 12:16:42 PM
 */
@Service
public class StoreServiceImpl implements StoreService {

	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

	private final StoreRepository storeRepository;

	public StoreServiceImpl(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@Override
	public StoreListResponse getStoreList(StoreListRequest request) {
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
		Page<Store> storePage = storeRepository.findAll(pageable);

		List<StoreDTO> storeDtos = storePage.getContent().stream().map(StoreDTO::new).collect(Collectors.toList());
		logger.info("Retrieved {} stores from page {} with size {}", storeDtos.size(), storePage.getNumber(),
				storePage.getSize());

		return new StoreListResponse(storeDtos, storePage.getNumber(), storePage.getSize(),
				storePage.getTotalElements(), storePage.getTotalPages());
	}

	@Override
	public void createStore(CreateStoreRequest request) {
		Store entity = convertEntityFromRequest(request);
		storeRepository.save(entity);
		logger.info("Created new store: {}", entity);
	}

	@Override
	public void updateStore(UpdateStoreRequest request) {
		Store existingStore = findExistingStore(request.getId());
		updateExistingStore(existingStore, request);
		storeRepository.save(existingStore);
		logger.info("Updated store: {}", existingStore);
	}

	private Store findExistingStore(String storeId) {
		return storeRepository.findById(storeId)
				.orElseThrow(() -> new EntityNotFoundException("Store not found with ID: " + storeId));
	}

	private void updateExistingStore(Store existingStore, UpdateStoreRequest request) {
		existingStore.setStorePhotoPath(request.getStorePhotoPath());
		existingStore.setStoreName(request.getStoreName());
		existingStore.setDistance(request.getDistance());
		existingStore.setDistanceUnit(request.getDistanceUnit());
		existingStore.setEta(request.getEta());
		existingStore.setEtaUnit(request.getEtaUnit());
		existingStore.setRating(request.getRating());
		existingStore.setCategory(request.getCategory());
		existingStore.setType(request.getType());
		
		Discount discount = new Discount();
		discount.setAvailable(request.getDiscountIsAvailable());
		discount.setDescription(request.getDiscountDescription());
		
		existingStore.setDiscount(discount);
		existingStore.setPromotion(request.getPromotion());
		existingStore.setUpdatedTime(LocalDateTime.now());
	}

	private Store convertEntityFromRequest(CreateStoreRequest request) {
		Store entity = new Store();
		entity.setStorePhotoPath(request.getStorePhotoPath());
		entity.setStoreName(request.getStoreName());
		entity.setDistance(request.getDistance());
		entity.setDistanceUnit(request.getDistanceUnit());
		entity.setEta(request.getEta());
		entity.setEtaUnit(request.getEtaUnit());
		entity.setRating(request.getRating());
		entity.setCategory(request.getCategory());
		entity.setType(request.getType());
		
		Discount discount = new Discount();
		discount.setAvailable(request.getDiscountIsAvailable());
		discount.setDescription(request.getDiscountDescription());
		
		entity.setDiscount(discount);
		entity.setPromotion(request.getPromotion());
		entity.setCreatedTime(LocalDateTime.now());
		entity.setUpdatedTime(LocalDateTime.now());
		return entity;
	}

	@Override
	public void deleteStore(DeleteStoreRequest request) {
		Store existingStore = findExistingStore(request.getId());
		storeRepository.delete(existingStore);
		logger.info("Deleted store with ID: {}", request.getId());
	}

}
