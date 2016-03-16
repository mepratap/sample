package com.cubic.entity.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.cubic.entity.ItemEntity;

public class ItemLoggingListener {

	@PrePersist
	public void beforePersist(ItemEntity entity) {
		entity.setItemName("Modified Item Name");
		System.out.println("ItemLoggingListener beforePersist " + entity);
	}

	@PostPersist
	public void afterPersist(ItemEntity entity) {
		System.out.println("ItemLoggingListener afterPersist " + entity);
	}

	@PostLoad
	public void afterLoad(ItemEntity entity) {
		System.out.println("ItemLoggingListener PostLoad " + entity);
	}

	@PreUpdate
	public void beforeUpdate(ItemEntity entity) {
		System.out.println("ItemLoggingListener beforeUpdate " + entity);
		entity.setItemDesc("Changed Desc " + System.currentTimeMillis());
		// System.out.println("Changed Desc dfield to m "+entity.getItemDesc());
	}

	@PostUpdate
	public void afterUpdate(ItemEntity entity) {
		System.out.println("ItemLoggingListener afterUpdate " + entity);
	}

}