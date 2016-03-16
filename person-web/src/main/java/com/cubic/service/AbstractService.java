package com.cubic.service;

import com.cubic.dao.ProductDAO;
import com.cubic.dao.ProductDetailDAO;

public abstract class AbstractService {
	private String version;

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		// TODO Auto-generated method stub
		return version;
	}

}
