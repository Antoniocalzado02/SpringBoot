package com.jacaranda.estanco.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint{
@Override
public void commence(HttpServletRequest request, HttpServletResponse response,
org.springframework.security.core.AuthenticationException authException)
throws IOException, ServletException {
response.addHeader("Content-Type", "application/json");
response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
final Map<String, Object> body = new HashMap<>();
body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
body.put("error", "Unauthorized");
body.put("message", authException.getMessage());
body.put("path", request.getServletPath());
final ObjectMapper mapper = new ObjectMapper();
try {
	mapper.writeValue(response.getOutputStream(), body);
} catch (StreamWriteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (DatabindException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (java.io.IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
