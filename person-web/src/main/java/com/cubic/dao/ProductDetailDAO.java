package com.cubic.dao;

import java.sql.SQLException;

import com.cubic.entity.ProductEntity;

public interface ProductDetailDAO {
	ProductEntity saveProductDetail(ProductEntity entity) throws SQLException;
}
