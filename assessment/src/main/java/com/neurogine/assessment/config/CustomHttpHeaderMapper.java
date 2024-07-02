package com.neurogine.assessment.config;

import org.springframework.integration.http.support.DefaultHttpHeaderMapper;

/**
 * @version : 1.0.0
 * @description :
 * @author : SanWaiLwin
 * @date : Jul 2, 2024 1:07:19 AM
 */
public class CustomHttpHeaderMapper extends DefaultHttpHeaderMapper {

    public CustomHttpHeaderMapper() {
        super();
        this.setOutboundHeaderNames(new String[]{"Content-Type", "Authorization", "X-Signature", "X-Nonce-Str", "X-Timestamp"});
    }
}
