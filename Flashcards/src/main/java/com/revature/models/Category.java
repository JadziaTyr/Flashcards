package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category {

	@Id
	@Column(name="categoryId")
	private int categoryId;
	@Column(name="text", nullable=false,unique=true)
	private String text;
	
	@Transient
	List<Category> subcategories;

	public Category() {
		super();
		this.categoryId = -1;
		this.text = "";
	}
	public Category(int categoryId, String text) {
		super();
		this.categoryId = categoryId;
		this.text = text;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", text=" + text + "]";
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
