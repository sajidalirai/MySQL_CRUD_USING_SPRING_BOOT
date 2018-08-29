package com.MysqlCRUDUsingSpring.interceptor;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimitingInterceptor extends HandlerInterceptorAdapter{

	
	private static final Logger logger = LoggerFactory.getLogger(RateLimitingInterceptor.class);
    
   // @Value("${rate.limit.enabled}")
    private boolean enabled = true;   
   // @Value("${rate.limit.hourly.limit}")
    private int hourlyLimit = 1;
 
    //private Map<String, Optional<SimpleRateLimiter>> limiters = new ConcurrentHashMap<>();
     
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!enabled) {
            return true;
        }
        String clientId = request.getHeader("Client-Id");
        // let non-API requests pass
        if (clientId == null) {
            return true;
        }
       
        SimpleRateLimiter rateLimiter = getRateLimiter(clientId);
        boolean allowRequest = rateLimiter.tryAcquire();
        
        System.out.println(allowRequest);
     
        
        if (!allowRequest) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        response.addHeader("X-RateLimit-Limit", String.valueOf(hourlyLimit));
        return allowRequest;
    }
     
    private SimpleRateLimiter getRateLimiter(String clientId) {
    	TimeUnit seconds = TimeUnit.MINUTES;
        return SimpleRateLimiter.create(3, seconds);
    }

}
