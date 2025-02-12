package com.neurogine.assessment.response;

import java.io.Serializable;
import java.util.List;

import com.neurogine.assessment.dto.StoreDTO;

import lombok.Data;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jun 30, 2024 12:25:46 PM
 */
@Data
public class StoreListResponse implements Serializable {

	private static final long serialVersionUID = 3190616016700509203L;
	
	private List<StoreDTO> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public StoreListResponse(List<StoreDTO> content, int page, int size, long totalElements, int totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

	public StoreListResponse() {
		super(); 
	} 

}
