package com.jacaranda.estanco.services;


import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.repository.UserRepository;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import net.bytebuddy.utility.RandomString;


@Service
public class UserService implements UserDetailsService{
	
		
	@Autowired
	private UserRepository repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repositorio.findById(username).orElse(null);
		if (user == null) {
		throw new UsernameNotFoundException("User not found");
		}
		return user;
		}
		
		public boolean enableUser(String code, String ursername) {
			User u=repositorio.findById(ursername).orElse(null);
			
			if(u.getVerificationCode().equals(code)) {
				u.setEnabled(true);
				repositorio.save(u);
			}
				return u.isEnabled();
	}
	


}
