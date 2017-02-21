package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="flashcard_topcategories")
@Component("chain")
public class Chain {
	
	@Id
	@Column(name="chainId")
	private int chainId;

	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category topCategory;
	
	@Autowired
	@OneToOne
	@JoinColumn(name="userId") 
	private User user;

	public Chain() {
		super();
		this.chainId = -1;
	}
	
	public Chain(int chainId, Category topCategory, User user) {
		super();
		this.chainId = chainId;
		this.topCategory = topCategory;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Chain [chainId=" + chainId + ", topCategory=" + topCategory + ", user=" + user + "]";
	}

	public int getChainId() {
		return chainId;
	}

	public void setChainId(int chainId) {
		this.chainId = chainId;
	}

	public Category getTopCategory() {
		return topCategory;
	}

	public void setTopCategory(Category topCategory) {
		this.topCategory = topCategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
