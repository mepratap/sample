package com.cubic.util;

public class NameService {

	private NameUtil nameUtil = null;

	public NameUtil getNameUtil() {
		return nameUtil;
	}

	public void setNameUtil(NameUtil nameUtil) {
		this.nameUtil = nameUtil;
	}

	public String getFormattedName(String firstName, String lastName) {
		return this.getNameUtil().getFullName(firstName, lastName);

	}
}
