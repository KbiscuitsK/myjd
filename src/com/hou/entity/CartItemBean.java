package com.hou.entity;

public class CartItemBean {
	//˽���ֶ�
    private Titles book;
    private int quantity;
    //�������췽��
	public CartItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItemBean(Titles book, int quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}
	//������setter && getter����
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
