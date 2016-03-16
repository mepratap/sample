package com.cubic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "ITEM_DETAIL")
public class ItemDetailEntity {

	@Id
	@Column(name = "DETAIL_ID")
	@GenericGenerator(name = "itemDetailId", strategy = "foreign", parameters = @Parameter(name = "property", value = "item"))
	@GeneratedValue(generator = "itemDetailId")
	private Long pk;

	@Column(name = "WIDTH")
	private String itemWidth;

	@Column(name = "HEIGHT")
	private String itemHeight;

	@Column(name = "COLOR")
	private String color;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ItemEntity item;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}

	public String getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemDetailEntity [pk=" + pk + ", itemWidth=" + itemWidth + ", itemHeight=" + itemHeight + ", color="
				+ color + "]";
	}

}