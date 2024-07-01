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
 * @date : Jun 30, 2024 2:58:22 PM
 */
@Data 
public class CreateStoreRequest implements Serializable {

	private static final long serialVersionUID = 1188400372093070605L;
   
	@NotBlank(message = "Store photo cannot be blank")
	private String storePhotoPath;
	
	@NotBlank(message = "Store name cannot be blank")
	private String storeName;

	@PositiveOrZero(message = "Ditance must be a positive number or zero")
	private double distance;
	
	@NotBlank(message = "Distance unit cannot be blank")
	private String distanceUnit;

	@PositiveOrZero(message = "Estimate time of arrival must be a positive number or zero")
	private int eta;
	
	@NotBlank(message = "Estimate time of arrival unit must be a positive number or zero")
	private String etaUnit;

	@PositiveOrZero(message = "Rating must be a positive number or zero")
	private double rating;

	@NotBlank(message = "Category cannot be blank")
	private String category;

	@NotBlank(message = "Type cannot be blank")
	private String type;
	
	@NotNull(message = "Discount availability must be specified")
    private Boolean discountIsAvailable; 
	
	@NotBlank(message = "Discount description cannot be blank")
	private String discountDescription;
	
	@NotBlank(message = "Promotion cannot be blank")
	private String promotion;
}
