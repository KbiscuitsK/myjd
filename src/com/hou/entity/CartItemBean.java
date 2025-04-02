package com.hou.entity;

public class CartItemBean {
	//私有字段
    private Titles book;
    private int quantity;
    //公开构造方法
	public CartItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItemBean(Titles book, int quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}
	//公开的setter && getter属性
	public Titles getBook() {
		return book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setBook(Titles book) {
		this.book = book;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
