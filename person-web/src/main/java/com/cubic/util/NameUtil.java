package com.cubic.util;

public class NameUtil {
	public String getFullName(String firstName, String lastName) {
		String result = null;
		if (firstName == null && lastName == null) {
			return result;
		}
		result = "";
		if (firstName != null) {
			result += firstName;
		}
		if (lastName != null) {
			result += "," + lastName;
		}
		return result;
	}
}
