package com.neurogine.assessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;

import com.neurogine.assessment.request.CreateStoreRequest;
import com.neurogine.assessment.request.DeleteStoreRequest;
import com.neurogine.assessment.request.StoreListRequest;
import com.neurogine.assessment.request.TopupRequest;
import com.neurogine.assessment.request.UpdateStoreRequest;
import com.neurogine.assessment.response.StoreListResponse;
import com.neurogine.assessment.service.StoreService;
import com.neurogine.assessment.service.TopupService;
import org.springframework.messaging.MessageHandler;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 1, 2024 9:12:52 AM
 */
@Configuration
public class IntegrationConfig {

	@Bean
	public DirectChannel getStoreListChannel() {
		return new DirectChannel();
	}

	@Bean
	public DirectChannel createStoreChannel() {
		return new DirectChannel();
	}

	@Bean
	public DirectChannel updateStoreChannel() {
		return new DirectChannel();
	}

	@Bean
	public DirectChannel deleteStoreChannel() {
		return new DirectChannel();
	}
	
	 @Bean
	    public DirectChannel topupRequestChannel() {
	        return new DirectChannel();
	    }

	@Bean
	public IntegrationFlow getStoreListFlow(StoreService storeService) {
		return IntegrationFlows.from("getStoreListChannel").handle(storeService, "getStoreList").get();
	}

	@Bean
	public IntegrationFlow createStoreFlow(StoreService storeService) {
		return IntegrationFlows.from("createStoreChannel").handle((payload, headers) -> {
			if (payload instanceof CreateStoreRequest) {
				storeService.createStore((CreateStoreRequest) payload);
			}
			return null;
		}).get();
	}

	@Bean
	public IntegrationFlow updateStoreFlow(StoreService storeService) {
		return IntegrationFlows.from("updateStoreChannel").handle((payload, headers) -> {
			if (payload instanceof UpdateStoreRequest) {
				storeService.updateStore((UpdateStoreRequest) payload);
			}
			return null;
		}).get();
	}

	@Bean
	public IntegrationFlow deleteStoreFlow(StoreService storeService) {
		return IntegrationFlows.from("deleteStoreChannel").handle((payload, headers) -> {
			if (payload instanceof DeleteStoreRequest) {
				storeService.deleteStore((DeleteStoreRequest) payload);
			}
			return null;
		}).get();
	}
	
	@Bean
    public MessageHandler topupRequestHandler() {
        HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler("https://sb-open.revenuemonster.my/v3/wallet/topup");
        handler.setHttpMethod(org.springframework.http.HttpMethod.POST);
        handler.setExpectedResponseType(String.class);
        handler.setHeaderMapper(new CustomHttpHeaderMapper());
        return handler;
    }

    @Bean
    public IntegrationFlow topupFlow(TopupService topupService) {
        return IntegrationFlows.from("topupRequestChannel")
                .handle(topupRequestHandler())
                .get();
    }

	@MessagingGateway(defaultRequestChannel = "getStoreListChannel")
	public interface GetStoreListGateway {
		StoreListResponse getStoreList(StoreListRequest request);
	}

	@MessagingGateway(defaultRequestChannel = "createStoreChannel")
	public interface CreateStoreGateway {
		void createStore(CreateStoreRequest request);
	}

	@MessagingGateway(defaultRequestChannel = "updateStoreChannel")
	public interface UpdateStoreGateway {
		void updateStore(UpdateStoreRequest request);
	}

	@MessagingGateway(defaultRequestChannel = "deleteStoreChannel")
	public interface DeleteStoreGateway {
		void deleteStore(DeleteStoreRequest request);
	}
	
	@MessagingGateway(defaultRequestChannel = "topupRequestChannel")
    public interface TopupGateway {
        void topup(TopupRequest request);
    }
}