package com.neurogine.assessment.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 2:33:16 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "stores")
public class Store extends BaseModel {

	private String storeName;
	private double distance;
	private int eta;
	private double rating;
	private String category;
	private String type;
	private Discount discount;
	private String promotion;

	@Data
	public static class Discount {
		private boolean available;
		private double amount;

	}

	public Store() {
	}

	public Store(String storeName, double distance, int eta, double rating, String category, String type,
			Discount discount, String promotion) {
		super();
		this.storeName = storeName;
		this.distance = distance;
		this.eta = eta;
		this.rating = rating;
		this.category = category;
		this.type = type;
		this.discount = discount;
		this.promotion = promotion;
	}

}
