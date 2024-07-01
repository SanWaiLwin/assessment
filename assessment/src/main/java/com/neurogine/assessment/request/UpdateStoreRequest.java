package com.neurogine.assessment.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 1, 2024 12:58:31 AM
 */
@Data 
public class UpdateStoreRequest implements Serializable {

	private static final long serialVersionUID = 1188400372093070605L;
  
	@NotBlank(message = "Id cannot be blank") 
	private String id;
	
	@NotBlank(message = "Store name cannot be blank")
	private String storeName;

	@PositiveOrZero(message = "Ditance must be a positive number or zero")
	private double distance;

	@PositiveOrZero(message = "Estimate time of arrival must be a positive number or zero")
	private int estimateTimeOfArrival;

	@PositiveOrZero(message = "Rating must be a positive number or zero")
	private double rating;

	@NotBlank(message = "Category cannot be blank")
	private String category;

	@NotBlank(message = "Type cannot be blank")
	private String type;
	
	@NotNull(message = "Discount availability must be specified")
    private Boolean discountIsAvailable;
	
	@PositiveOrZero(message = "Discount amount must be a positive number or zero")
	private double discountAmount;
	
	@NotBlank(message = "Promotion cannot be blank")
	private String promotion;
}

