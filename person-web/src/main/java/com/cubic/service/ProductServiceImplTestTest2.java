package com.cubic.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.cubic.dao.ProductDAO;
import com.cubic.entity.ProductEntity;
import com.cubic.group.ProductData;
import com.cubic.util.NameService;
import com.cubic.util.NameUtil;
import com.cubic.vo.ProductVO;

public class ProductServiceImplTestTest2 {

	private ProductServiceImpl service = null;

	@Before
	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductProductionNameNull() {
		ProductVO input = ProductData.createProduct();
		input.setProductName(null);
		service.saveProduct(input);
	}

	@Test
		public void testSaveProductCreate()throws SQLException{
			ProductVO input=ProductData.createProduct();
			ProductEntity savedEntity=ProductData.createProductEntity();
			ProductDAO dao=mock(ProductDAO.class);
			service.setProductDAO(dao);
			when(dao.saveProduct(any(ProductEntity.class))).thenReturn(savedEntity);
			ProductVO output=service.saveProduct(input);
			assertNotNull(input);
			verify(dao,time(1)).saveProduct
			
		}

	@Test
	public void testMock() throws SQLException {
		NameService nameService = new NameService();
		NameUtil nameUtil = mock(NameUtil.class);
		when(nameUtil.getFullName("rosy", "hamal")).thenReturn("rhamal");
		nameService.setNameUtil(nameUtil);
		String result = nameService.getFormattedName("rosy", "hamal");
		assertEquals("rhamal", result);
	}
}
