package com.cubic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubic.entity.listeners.ItemLoggingListener;

@Entity
@Table(name = "ITEM")
@NamedNativeQueries({
		@NamedNativeQuery(name = "ItemEntity.findAll", query = "select * from ITEM", resultClass = ItemEntity.class),
		@NamedNativeQuery(name = "ItemEntity.count", query = "select count(*) from ITEM", resultClass = ItemEntity.class),
		@NamedNativeQuery(name = "ItemEntity.cols", query = "select from ITEM", resultClass = ItemEntity.class) })
@EntityListeners({ ItemLoggingListener.class })
public class ItemEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "retailSeq", sequenceName = "PERSON_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "retailSeq")
	private Long pk;

	@Column(name = "ITEMNAME")
	private String itemName;

	@Column(name = "ITEMDESC")
	private String itemDesc;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
	private ItemDetailEntity itemDetailEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAT_ID")
	private CategoryEntity category;

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public ItemDetailEntity getItemDetailEntity() {
		return itemDetailEntity;
	}

	public void setItemDetailEntity(ItemDetailEntity itemDetailEntity) {
		this.itemDetailEntity = itemDetailEntity;
	}

	@Override
	public String toString() {
		return "Item [pk=" + pk + ", itemName=" + itemName + ", itemDesc=" + itemDesc + "]";
	}

}