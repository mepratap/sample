package com.cubic.service;

import java.sql.SQLException;

import com.cubic.service.exception.DuplicateProductException;
import com.cubic.vo.ProductVO;

public interface ProductService {
	ProductVO saveProduct(ProductVO vo) throws DuplicateProductException, SQLException;
}
