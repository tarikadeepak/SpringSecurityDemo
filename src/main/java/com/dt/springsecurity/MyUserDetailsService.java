package com.dt.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);
		System.out.println("Password : " + user.getPassword() + " " + user.getUsername());
		if(user==null)
			throw new UsernameNotFoundException("User Not found");
		
		return new UserPrincipal(user);
	}
	
}
