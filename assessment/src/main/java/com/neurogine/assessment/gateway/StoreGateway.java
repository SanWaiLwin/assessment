package com.neurogine.assessment.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Payload;

import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.response.StoreListResponse;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 1, 2024 9:42:04 AM
 */
@MessagingGateway(defaultRequestChannel = "inputChannel", defaultReplyChannel = "outputChannel")
public interface StoreGateway {
    StoreListResponse getStoreList(@Payload StoreListRequest request);
}
