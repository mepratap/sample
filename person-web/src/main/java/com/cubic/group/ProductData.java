package com.cubic.group;

import com.cubic.entity.ProductEntity;
import com.cubic.vo.ProductVO;

public class ProductData {
	public static ProductVO createProduct() {
		ProductVO vo = new ProductVO();
		vo.setProductName("Laptop Dell");
		vo.setDescription("17 inch");
		return vo;
	}

	public static ProductEntity createProductEntity() {
		ProductEntity vo = new ProductEntity();
		vo.setProductName("Laptop Dell");
		vo.setDescription("17 inch");
		vo.setId(new Long(1000));
		return vo;
	}
}
