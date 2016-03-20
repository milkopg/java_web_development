package bg.softuni.banking.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.softuni.banking.dao.AccountDao;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	AccountDao accountDao;
	
	/**
	 *  added 2 users in db: username: user role: ROLE_USER password: 111111 ,
	 *  username: bank role: ROLE_BANK_EMPLOYEE password: 222222 
	 */
	List<GrantedAuthority> authorities = new ArrayList<>();
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		bg.softuni.banking.entities.User dbUser = null;
		if (username == null ) {
			return null;
		} else {
			dbUser = accountDao.getUserByUsername(username);
			if (username.equals(dbUser.getUsername())) {
				authorities.add(new SimpleGrantedAuthority(dbUser.getRole()));
			} 
		}
		return new User(username, dbUser.getPassword(), authorities);
	}
}