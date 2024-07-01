package com.neurogine.assessment.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 1, 2024 12:11:57 AM
 */
@Data
public class BaseModel {
 
	@Id
    private String id;
	
    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime updatedTime;
}
