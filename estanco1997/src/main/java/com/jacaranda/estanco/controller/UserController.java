package com.jacaranda.estanco.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.security.JwtUtils;
import com.jacaranda.estanco.security.LoginCredential;
import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.services.UserService;


import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST })


@RestController
public class UserController {

	private static final String REDIRECT_USER = "redirect:/usersList";

	@Autowired
	UserService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginCredential loginRequest) {
		// Si el usuario y el password que le paso son los adecuados me devuele un
		// autentication
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();
		String jwt = JwtUtils.generateToken(loginRequest.getName(), user.getEmail(), user.getRole());
		User userDetails = (User) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(jwt);
	}
	

}
