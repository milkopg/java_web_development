package bg.softuni.banking.utility;

import org.springframework.security.core.context.SecurityContextHolder;

import bg.softuni.banking.security.User;

public class UserUtils {
	private UserUtils() {}
	
	public static User getUser() {
		Object principal;
		
		try {
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (NullPointerException npe) {
			return null;
		}
		
		if (!(principal instanceof User)) return null;
		return (User) principal;
	}
}
