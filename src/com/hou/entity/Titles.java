package com.hou.entity;

public class Titles {            //定义了一个公共类Titles这个类用于表示图书的标题信息
	//私有字段
		private String copyright;  //声明了-个私有字符串字段 copyright ，用于存储图书的版权信息。
		private int editionnumber;  //声明了个私有整数字段 editionnumber ，用于存储图书的版本号
		private String imagefile;   //封面图片文件路径
		private String isbn;          //国际标准书号
		private double price;        //声明了一个私有双精度浮点数字段 price ，用于存储图书的价格
		public int publisherId;     //声明了一个公共整数字段 publisherd ，用于存储出版的ID
		private String title;        //声明了一个私有字符串字段 tit1e ，用于存储图书的标题
	    //空构造方法
		public Titles() {       //创建一个默认的titles对象

		}
	    //全参构造方法
		public Titles(String isbn, String title, int editionnumber, String copyright, int publisherId, String imagefile,
				double price) {  //定义了全参构造方法，它接受7个参数，分别对应于类的7个私有字段，用于创建一个带有所有详细信息的 Titles对象。

			this.isbn = isbn;
			this.title = title;
			this.editionnumber = editionnumber;
			this.copyright = copyright;
			this.publisherId = publisherId;
			this.imagefile = imagefile;
			this.price = price;
		}
	   //所有私有字段的公开属性--setter&getter() 
		public String getCopyright() {   //每个私有字段都对应一个公开的 getter方法，用于获取字段的值。
			return copyright;
		}

		public int getEditionnumber() {
			return editionnumber;
		}

		public String getImagefile() {
			return imagefile;
		}

		public String getIsbn() {
			return isbn;
		}

		public double getPrice() {
			return price;
		}

		public int getPublisherId() {
			return publisherId;
		}

		public String getTitle() {
			return title;
		}

		public void setCopyright(String copyright) {  //每个私有字段都对应一个公开的 setter方法，用于设置字段的值。
			this.copyright = copyright;
		}

		public void setEditionnumber(int editionnumber) {
			this.editionnumber = editionnumber;
		}

		public void setImagefile(String imagefile) {
			this.imagefile = imagefile;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public void setPublisherId(int publisherId) {
			this.publisherId = publisherId;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}
