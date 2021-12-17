package sv.com.telefonica.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import sv.com.telefonica.model.dto.ActCustomUserDetailsDto;
import sv.com.telefonica.model.entity.ActUsuarioEntity;
import sv.com.telefonica.model.repository.ActUsuarioRepository;

public class ActUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
    private ActUsuarioRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ActUsuarioEntity user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new ActCustomUserDetailsDto(user);
	}

}
