package com.cubic.service;

import java.sql.SQLException;

import com.cubic.dao.ProductDAO;
import com.cubic.dao.ProductDAOImpl;
import com.cubic.dao.ProductDetailDAO;
import com.cubic.dao.ProductDetailDAOImpl;
import com.cubic.entity.ProductEntity;
import com.cubic.service.exception.DuplicateProductException;
import com.cubic.service.exception.ProductException;
import com.cubic.vo.ProductVO;

public class ProductServiceImpl extends AbstractService implements ProductService {

	private ProductMapper mapper = new ProductMapper();

	private ProductDAO dao = null;

	private ProductDetailDAO detailDao = new ProductDetailDAOImpl();

	@Override
	public ProductVO saveProduct(ProductVO vo) throws DuplicateProductException {
		if (vo == null || vo.getProductName() == null) {
			throw new IllegalArgumentException("Invalid parameters to save product");
		}

		ProductEntity entity = new ProductEntity();

		try {
			if (vo.getId() != null) {
				entity = getProductDAO().find(vo.getId());
			}

			entity = mapper.mapToProductEntity(entity, vo);
			entity = getProductDAO().saveProduct(entity);
			entity = getProductDAO().saveProduct(entity);
			vo.setId(entity.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ProductException(e.getMessage());
		}

		return vo;
	}

	void setProductDAO(ProductDAO dao) {
		this.dao = dao;
	}

	ProductDAO getProductDAO() {
		if (this.dao == null) {
			dao = new ProductDAOImpl();
		}

		return dao;
	}

}
