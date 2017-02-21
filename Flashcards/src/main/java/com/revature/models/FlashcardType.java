package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class FlashcardType {
	@Id
	@Column(name="typeId")
	private int typeId;
	@Column(name="text", nullable=false,unique=true)
	private String text;
	public FlashcardType() {
		super();
		this.typeId = -1;
		this.text = "";
	}
	public FlashcardType(int typeId, String text) {
		super();
		this.typeId = typeId;
		this.text = text;
	}
	@Override
	public String toString() {
		return "FlashcardType [typeId=" + typeId + ", text=" + text + "]";
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}