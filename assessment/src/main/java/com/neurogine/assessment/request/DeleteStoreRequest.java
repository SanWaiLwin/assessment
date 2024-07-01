package com.neurogine.assessment.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 1, 2024 12:51:52 AM
 */
@Data
public class DeleteStoreRequest implements Serializable{
	
	private static final long serialVersionUID = 447048715783982742L;
	
	@NotBlank(message = "Id cannot be blank") 
	private String id;

}
