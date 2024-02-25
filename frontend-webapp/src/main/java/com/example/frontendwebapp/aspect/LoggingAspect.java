package com.example.frontendwebapp.aspect;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LoggingAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Autowired
    private HttpServletRequest request;

    @After("within(com.example.frontendwebapp.app.frontController)")
    public void logAfterReturning(JoinPoint joinPoint) {
        // ログ要素
        String ipAddress = request.getRemoteAddr();
        String method = joinPoint.getSignature().getName();
        String userId = getUserId();
        String host = getServerName();
        String sessionId = getSessionId();

        // ログのフォーマット
        String logMessage = String.format("Method: %s, IP: %s, User: %s, Host: %s, SessionId: %s", method , ipAddress, userId, host, sessionId);

        // メソッド実行後のログ出力
        logger.info(logMessage);
    }
    
    private String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null) ? authentication.getName() : "Anonymous";
    }

    private String getServerName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unknown";
        }
    }

    private String getSessionId() {
        return RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes
                ? ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getId()
                : "No session";
    }
}
