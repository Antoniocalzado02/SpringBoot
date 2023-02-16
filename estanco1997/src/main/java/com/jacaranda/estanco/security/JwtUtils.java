package com.jacaranda.estanco.security;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	
	private final static String ACCESS_TOKEN_SECRET =
			"sksksskskskskiwoapqowlakskiwoaskskskskiwoapqowlapqowla";
	
	private final static Long ACCESS_TOKEN_VALIDATY_SECONDS = (long) 2592000;

	
	public static String generateToken(String username, String email,String role) {
		
		Date expirationDate = new Date(System.currentTimeMillis()+
				ACCESS_TOKEN_VALIDATY_SECONDS*1000);
		
		Map<String,Object> extra = new HashMap<>();
		extra.put("email", email);
		extra.put("role", role);
		
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
		
		return "Bearer "+token;
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
		//Claims == PayLoad
		Claims claims = Jwts.parserBuilder()
		.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
		.build()
		.parseClaimsJws(token)
		.getBody();
		String username = claims.getSubject();
		String role = (String) claims.get("role");
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
			return new UsernamePasswordAuthenticationToken(username,null,authorities);
			} catch (JwtException e) {
			return null;
			}
		}
	
	
}
