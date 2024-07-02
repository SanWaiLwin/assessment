package com.neurogine.assessment.service;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 2, 2024 12:30:13 AM
 */
public interface TopupService { 

	public void topupWallet(String redirectUrl, long amount);
}
