package com.neurogine.assessment.request;

import java.io.Serializable;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 2, 2024 1:09:08 AM
 */
@Data
public class TopupRequest implements Serializable {
	
	private static final long serialVersionUID = 3924505212114684351L;
	
	private String redirect;
    private long amount;

}
