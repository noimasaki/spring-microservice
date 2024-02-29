package com.example.backenditem.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TrackingInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(TrackingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // リクエストヘッダーからトラッキングIDを取得
        String trackingId = request.getHeader("X-Tracking-ID");

        // トラッキングIDが存在する場合、それをログに記録
        if (trackingId != null) {
            logger.info("Handling request with Tracking ID: {}", trackingId);
        } else {
            logger.info("Handling request without Tracking ID");
        }

        return true;
    }
    
}
