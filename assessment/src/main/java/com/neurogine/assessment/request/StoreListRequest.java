package com.neurogine.assessment.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 12:25:35 PM
 */
@Data
public class StoreListRequest implements Serializable {

	private static final long serialVersionUID = -6601620740671759591L;
	 
	@Min(value = 0, message = "Page number cannot be less than 0")
    private int page;

    @Min(value = 1, message = "Page size must be at least 1")
    private int size;
   
}
