package com.example.clickup_com.security;

import com.example.clickup_com.entity.enums.SystemRoleName;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {
    String parol="0000";
    public String token(String username){

        long vaqt=24*60*60*1000;
        Date muddat=new Date(System.currentTimeMillis()+vaqt);


        String tokenn = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(muddat)
                .claim("roles",SystemRoleName.USER)
                .signWith(SignatureAlgorithm.HS512, parol)
                .compact();
        return  tokenn;
    }
    public boolean tokenCheck(String token){
        Jwts
                .parser()
                .setSigningKey(parol)
                .parseClaimsJws(token);
        return true;
    }

    public String usernameolish(String token){
        String subject = Jwts
                .parser()
                .setSigningKey(parol)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return subject;
    }
}

