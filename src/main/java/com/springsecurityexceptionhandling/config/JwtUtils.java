package com.springsecurityexceptionhandling.config;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class JwtUtils {

    private static final Logger logger = LogManager.getLogger(JwtUtils.class);

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private String getJwtFromHeader(HttpServletRequest request){
        String bearerToken= request.getHeader("Authorization");
        logger.debug("Authorisation Header :{}", bearerToken);
        if(bearerToken !=null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    private String generateTokenFromUsername(UserDetails userDetails){
        return null;
    }
}

