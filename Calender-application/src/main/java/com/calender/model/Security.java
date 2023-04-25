package com.calender.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class Security {
	
	private static final long serialVersionUID = 1L;
	
	private MyUser mUser;
	
	public Security(MyUser mUser) {
		this.mUser = mUser;
	}
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.mUser.getRole());
		grantedAuthorities.add(grantedAuthority);
		
		
		return grantedAuthorities;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.mUser.getPassword();
	}

	public String getUsername() {
		
		return this.mUser.getUserName();
	}

	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
	
		return true;
	}

}
