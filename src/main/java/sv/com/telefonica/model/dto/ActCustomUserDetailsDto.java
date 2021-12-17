package sv.com.telefonica.model.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import sv.com.telefonica.model.entity.ActUsuarioEntity;

public class ActCustomUserDetailsDto implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ActUsuarioEntity user;

	public ActCustomUserDetailsDto(ActUsuarioEntity user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getUser().getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getUser().getEmail();
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
		return true;
	}

	public ActUsuarioEntity getUser() {
		return user;
	}

	public void setUser(ActUsuarioEntity user) {
		this.user = user;
	}

	public String getFullName() {
		return user.getFirstName() + " " + user.getLastName();
	}

}
