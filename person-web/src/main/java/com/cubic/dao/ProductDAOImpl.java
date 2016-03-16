package com.cubic.dao;

import java.sql.SQLException;

import com.cubic.entity.ProductEntity;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public ProductEntity saveProduct(ProductEntity entity) throws SQLException {
		throw new SQLException("This is an error method");
	}

	@Override
	public ProductEntity find(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ProductEntity entity) throws SQLException {
		// TODO Auto-generated method stub

	}

}
