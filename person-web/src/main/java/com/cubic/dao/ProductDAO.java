package com.cubic.dao;

import java.sql.SQLException;

import com.cubic.entity.ProductEntity;

public interface ProductDAO {
	ProductEntity saveProduct(ProductEntity entity) throws SQLException;

	ProductEntity find(Long id) throws SQLException;

	void remove(ProductEntity entity) throws SQLException;
}
