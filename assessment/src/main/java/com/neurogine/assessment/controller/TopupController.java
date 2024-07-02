package com.neurogine.assessment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neurogine.assessment.config.IntegrationConfig.TopupGateway;
import com.neurogine.assessment.request.TopupRequest;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 2, 2024 12:29:18 AM
 */
@RestController
public class TopupController {

	private final TopupGateway topupGateway;

	public TopupController(TopupGateway topupGateway) {
		this.topupGateway = topupGateway; 
	}

	@PostMapping("/topup")
	public void topup(@RequestBody TopupRequest topupRequest) {
		topupGateway.topup(topupRequest);
	}
}
