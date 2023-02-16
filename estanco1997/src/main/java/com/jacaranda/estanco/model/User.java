package com.jacaranda.estanco.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User implements UserDetails{		
			@Id
			private String username;
			private String pass;
			private String name;
			private String email;
			private String role;
			private String verificationCode;
			private Boolean enabled;
			private String image;
			@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
			private List<Pedido> listOrders;

		public User() {
		}

		public User(String username, String password, String name, String email, String role, String verification, Boolean enabled, String image) {
			super();
			this.username = username;
			this.pass = password;
			this.name = name;
			this.role=role;
			this.email = email;
			this.verificationCode=verification;
			this.enabled=enabled;
			this.image=image;
			this.listOrders=new ArrayList<Pedido>();
		}

	

		public void setUsername(String username) {
			this.username = username;
		}


		public void setPassword(String password) {
			this.pass = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getVerificationCode() {
			return verificationCode;
		}

		public void setVerification_code(String verificationCode) {
			this.verificationCode = verificationCode;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}
		
		
		
		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
		

		public List<Pedido> getListOrders() {
			return listOrders;
		}

		public void setListOrders(List<Pedido> listOrders) {
			this.listOrders = listOrders;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			String role = this.getRole();
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(role));
			return authorities;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return pass;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return this.username;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return enabled;
		}
			

		@Override
		public int hashCode() {
			return Objects.hash(name, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(name, other.name) && Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "Users [username=" + username + ", name=" + name + ", email="
					+ email +  "]";
		}

		
		
	


}
