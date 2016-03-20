package bg.jwd.uni.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import bg.jwd.uni.security.User;

public class UserUtils {

	private UserUtils() {
	}

	public static User getUser() {
		Object principal;

		try {
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (NullPointerException e) {
			return null;
		}

		if (principal == null || !(principal instanceof User)) {
			return null;
		}

		return (User) principal;
	}
}