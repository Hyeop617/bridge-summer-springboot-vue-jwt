package com.hyeop.bridgesummer.service;

import com.hyeop.bridgesummer.domain.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    private static final String SALT =  "SALTHYEOP";

    public String create(User user){
        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setSubject("login")
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 1000 * 5))         // 5분
                .claim("User",user)
                .signWith(SignatureAlgorithm.HS256, SALT.getBytes())
                .compact();
        return jwt;
    }

    public Map<String, Object> get(String jwt) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//        String jwt = request.getHeader("Authorization").split(" ")[1];
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SALT.getBytes())
                    .parseClaimsJws(jwt);
        } catch (Exception e) {
            throw new RuntimeException();
        }
//        Map<String, Object> value = (LinkedHashMap<String, Object>)claims.getBody().get(key);
//        System.out.println(value);
        return claims.getBody();
    }

    public long getMemberId() {
        Integer memberId = (Integer) this.get("member").get("id");
        return new Long(memberId);
    }

    public boolean isUsable(String jwt) {
        try{
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(SALT.getBytes())
                    .parseClaimsJws(jwt);
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
