package com.neurogine.assessment.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neurogine.assessment.config.IntegrationConfig.TopupGateway;
import com.neurogine.assessment.request.TopupRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 3, 2024 10:59:49 AM
 */
@WebMvcTest(TopupController.class)
@ExtendWith(MockitoExtension.class)
class TopupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopupGateway topupGateway;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testTopup_shouldCallTopupGateway() throws Exception {
        TopupRequest request = new TopupRequest();
         
        doNothing().when(topupGateway).topup(any(TopupRequest.class));

        mockMvc.perform(post("/topup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        verify(topupGateway, times(1)).topup(any(TopupRequest.class));
    } 
}
