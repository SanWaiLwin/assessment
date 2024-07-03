package com.neurogine.assessment.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.neurogine.assessment.config.IntegrationConfig.CreateStoreGateway;
import com.neurogine.assessment.config.IntegrationConfig.DeleteStoreGateway;
import com.neurogine.assessment.config.IntegrationConfig.GetStoreListGateway;
import com.neurogine.assessment.config.IntegrationConfig.UpdateStoreGateway;
import com.neurogine.assessment.dto.StoreDTO;
import com.neurogine.assessment.model.Store;
import com.neurogine.assessment.request.CreateStoreRequest;
import com.neurogine.assessment.request.DeleteStoreRequest;
import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.request.UpdateStoreRequest;
import com.neurogine.assessment.response.StoreListResponse; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

class StoreControllerTest {

    @Mock
    private GetStoreListGateway getStoreListGateway;

    @Mock
    private CreateStoreGateway createStoreGateway;

    @Mock
    private UpdateStoreGateway updateStoreGateway;

    @Mock
    private DeleteStoreGateway deleteStoreGateway;

    @InjectMocks
    private StoreController storeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStoreList() {
        StoreListRequest request = new StoreListRequest();
        request.setPage(0);
        request.setSize(10);

        StoreDTO store1 = new StoreDTO(new Store());
        StoreDTO store2 = new StoreDTO(new Store());
        StoreListResponse expectedResponse = new StoreListResponse(Arrays.asList(store1, store2), 0, 10, 2, 0);

        when(getStoreListGateway.getStoreList(any(StoreListRequest.class))).thenReturn(expectedResponse);

        storeController.getStoreList(request);

        verify(getStoreListGateway).getStoreList(any(StoreListRequest.class)); 
    }

    @Test
    void testCreateStore() {
        CreateStoreRequest request = new CreateStoreRequest();
        request.setStorePhotoPath("photo/path.jpg");
        request.setStoreName("New Store");
        request.setDistance(5.0);
        request.setDistanceUnit("km");
        request.setEta(15);
        request.setEtaUnit("minutes");
        request.setRating(4.5);
        request.setCategory("Food");
        request.setType("Restaurant");
        request.setDiscountIsAvailable(true);
        request.setDiscountDescription("10% off");
        request.setPromotion("Buy 1 Get 1 Free");

        ResponseEntity<String> response = storeController.createStore(request);

        verify(createStoreGateway).createStore(any(CreateStoreRequest.class)); 
    }

    @Test
    void testUpdateStore() {
        UpdateStoreRequest request = new UpdateStoreRequest();
        request.setStorePhotoPath("photo/path.jpg");
        request.setStoreName("New Store");
        request.setDistance(5.0);
        request.setDistanceUnit("km");
        request.setEta(15);
        request.setEtaUnit("minutes");
        request.setRating(4.5);
        request.setCategory("Food");
        request.setType("Restaurant");
        request.setDiscountIsAvailable(true);
        request.setDiscountDescription("10% off");
        request.setPromotion("Buy 1 Get 1 Free");

        ResponseEntity<String> response = storeController.updateStore(request);

        verify(updateStoreGateway).updateStore(any(UpdateStoreRequest.class)); 
    }

    @Test
    void testDeleteStore() {
        DeleteStoreRequest request = new DeleteStoreRequest();
        request.setId("234532453454"); 

        ResponseEntity<String> response = storeController.deleteStore(request);

        verify(deleteStoreGateway).deleteStore(any(DeleteStoreRequest.class)); 
    }
}
