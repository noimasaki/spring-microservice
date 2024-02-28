package com.example.frontendwebapp.app;

import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class TrackingFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        // HTTPリクエストを扱うために、ServletRequestをHttpServletRequestにキャスト
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // トラッキングIDをUUIDを使って生成
        String trackingId = UUID.randomUUID().toString();

        // 生成したトラッキングIDをリクエストの属性にセット
        request.setAttribute("X-Tracking-ID", trackingId);

        // コンソールにトラッキングIDを出力（本番環境ではLoggerを使用すること）
        System.out.println("Generated Tracking ID: " + trackingId + " for request to " + request.getRequestURI());

        // リクエスト処理を次のフィルターまたは最終的な目的地（コントローラー）に渡す
        chain.doFilter(request, servletResponse);
    }
}
