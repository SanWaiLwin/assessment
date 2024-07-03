package com.neurogine.assessment.service.impl;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.neurogine.assessment.exception.EntityNotFoundException;
import com.neurogine.assessment.model.Store;
import com.neurogine.assessment.model.Store.Discount;
import com.neurogine.assessment.repository.StoreRepository;
import com.neurogine.assessment.request.CreateStoreRequest;
import com.neurogine.assessment.request.DeleteStoreRequest;
import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.request.UpdateStoreRequest;
import com.neurogine.assessment.response.StoreListResponse;

import java.util.List;
import java.util.Arrays;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 2, 2024 9:51:19 PM
 */
@ExtendWith(MockitoExtension.class)
class StoreServiceImplTest {

	@Mock
	private StoreRepository storeRepository;

	@InjectMocks
	private StoreServiceImpl storeServiceImpl;

	private Store store;
	private CreateStoreRequest createStoreRequest;
	private UpdateStoreRequest updateStoreRequest;
	private DeleteStoreRequest deleteStoreRequest;
	private StoreListRequest storeListRequest;

	@BeforeEach
	void setUp() {
		store = new Store();
		store.setId("124235245345435");
		store.setStoreName("StoreName");
		store.setDistance(10);
		store.setDistanceUnit("km");
		store.setEta(15);
		store.setEtaUnit("min");
		store.setRating(4.5);
		store.setCategory("Category");
		store.setType("Type");

		Discount discount = new Discount();
		discount.setAvailable(true);
		discount.setDescription("DiscountDescription");

		store.setDiscount(discount);
		store.setPromotion("Promotion");

		createStoreRequest = new CreateStoreRequest();
		createStoreRequest.setStoreName("StoreName");
		createStoreRequest.setDistance(10);
		createStoreRequest.setDistanceUnit("km");
		createStoreRequest.setEta(15);
		createStoreRequest.setEtaUnit("min");
		createStoreRequest.setRating(4.5);
		createStoreRequest.setCategory("Category");
		createStoreRequest.setType("Type");
		createStoreRequest.setDiscountIsAvailable(true);
		createStoreRequest.setDiscountDescription("DiscountDescription");
		createStoreRequest.setPromotion("Promotion");

		updateStoreRequest = new UpdateStoreRequest();
		updateStoreRequest.setId("124235245345436");
		updateStoreRequest.setStoreName("UpdatedStoreName");
		updateStoreRequest.setDistance(20);
		updateStoreRequest.setDistanceUnit("miles");
		updateStoreRequest.setEta(30);
		updateStoreRequest.setEtaUnit("minutes");
		updateStoreRequest.setRating(5.0);
		updateStoreRequest.setCategory("UpdatedCategory");
		updateStoreRequest.setType("UpdatedType");
		updateStoreRequest.setDiscountIsAvailable(false);
		updateStoreRequest.setDiscountDescription("UpdatedDiscountDescription");
		updateStoreRequest.setPromotion("UpdatedPromotion");

		deleteStoreRequest = new DeleteStoreRequest();
		deleteStoreRequest.setId("storeId");

		storeListRequest = new StoreListRequest();
		storeListRequest.setPage(0);
		storeListRequest.setSize(10);
	}

	@Test
	void testGetStoreList() {
		Pageable pageable = PageRequest.of(storeListRequest.getPage(), storeListRequest.getSize());
		List<Store> stores = Arrays.asList(store);
		Page<Store> storePage = new PageImpl<>(stores, pageable, stores.size());

		when(storeRepository.findAll(pageable)).thenReturn(storePage);

		StoreListResponse response = storeServiceImpl.getStoreList(storeListRequest);

		assertEquals(1, response.getContent().size());
		assertEquals("StoreName", response.getContent().get(0).getStoreName());
		verify(storeRepository, times(1)).findAll(pageable);
	}

	@Test
	void testCreateStore() {
		when(storeRepository.save(any(Store.class))).thenReturn(store);

		storeServiceImpl.createStore(createStoreRequest);

		verify(storeRepository, times(1)).save(any(Store.class));
	}

	@Test
	void testUpdateStore() {
		when(storeRepository.findById(anyString())).thenReturn(Optional.of(store));
		when(storeRepository.save(any(Store.class))).thenReturn(store);

		storeServiceImpl.updateStore(updateStoreRequest);

		verify(storeRepository, times(1)).findById(anyString());
		verify(storeRepository, times(1)).save(any(Store.class));
	}

	@Test
	void testDeleteStore() {
		when(storeRepository.findById(anyString())).thenReturn(Optional.of(store));

		storeServiceImpl.deleteStore(deleteStoreRequest);

		verify(storeRepository, times(1)).findById(anyString());
		verify(storeRepository, times(1)).delete(any(Store.class));
	}

	@Test
	void testDeleteStoreNotFound() {
		when(storeRepository.findById(anyString())).thenReturn(Optional.empty());

		assertThrows(EntityNotFoundException.class, () -> {
			storeServiceImpl.deleteStore(deleteStoreRequest);
		});

		verify(storeRepository, times(1)).findById(anyString());
		verify(storeRepository, times(0)).delete(any(Store.class));
	}

}
