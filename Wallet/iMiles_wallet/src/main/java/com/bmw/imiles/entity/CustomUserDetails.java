/*
 * package com.bmw.imiles.entity;
 * 
 * import java.util.ArrayList; import java.util.Collection; import
 * java.util.List;
 * 
 * import org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails;
 * 
 * public class CustomUserDetails implements UserDetails {
 * 
 *//**
	* 
	*//*
		 * private static final long serialVersionUID = 1L; private String userName;
		 * private String password;
		 * 
		 * private Collection<? extends GrantedAuthority> authorities;
		 * 
		 * public CustomUserDetails(User byUserName) { this.userName =
		 * byUserName.getUserName(); this.password = byUserName.getPassword();
		 * List<GrantedAuthority> auths = new ArrayList<>(); for(Role
		 * role:byUserName.getRoleList()) auths.add(new
		 * SimpleGrantedAuthority(role.getName().toUpperCase())); this.authorities =
		 * auths; }
		 * 
		 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
		 * return authorities; }
		 * 
		 * @Override public String getPassword() { return password; }
		 * 
		 * @Override public String getUsername() { return userName; }
		 * 
		 * @Override public boolean isAccountNonExpired() { return false; }
		 * 
		 * @Override public boolean isAccountNonLocked() { return false; }
		 * 
		 * @Override public boolean isCredentialsNonExpired() { return false; }
		 * 
		 * @Override public boolean isEnabled() { return false; }
		 * 
		 * }
		 */