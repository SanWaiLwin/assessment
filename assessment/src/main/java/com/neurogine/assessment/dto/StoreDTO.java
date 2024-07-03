package com.neurogine.assessment.dto;

import java.io.Serializable;

import com.neurogine.assessment.model.Store;
import com.neurogine.assessment.model.Store.Discount;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 2:21:10 PM
 */
@Data
public class StoreDTO implements Serializable {

	private static final long serialVersionUID = 7543987644815754190L;

	private String id;
	private String storePhotoPath;
	private String storeName;
	private double distance;
	private String distanceUnit;
	private int eta;
	private String etaUnit;
	private double rating;
	private String category;
	private String type;
	private Discount discount;
	private String promotion;

	public StoreDTO(Store entity) {
		super();
		this.id = entity.getId();
		this.storePhotoPath = entity.getStorePhotoPath();
		this.storeName = entity.getStoreName();
		this.distance = entity.getDistance();
		this.distanceUnit = entity.getDistanceUnit();
		this.eta = entity.getEta();
		this.etaUnit = entity.getEtaUnit();
		this.rating = entity.getRating();
		this.category = entity.getCategory();
		this.type = entity.getType();
		this.discount = entity.getDiscount();
		this.promotion = entity.getPromotion();
	}

}
