package com.hou.entity;

public class Titles {            //������һ��������Titles��������ڱ�ʾͼ��ı�����Ϣ
	//˽���ֶ�
		private String copyright;  //������-��˽���ַ����ֶ� copyright �����ڴ洢ͼ��İ�Ȩ��Ϣ��
		private int editionnumber;  //�����˸�˽�������ֶ� editionnumber �����ڴ洢ͼ��İ汾��
		private String imagefile;   //����ͼƬ�ļ�·��
		private String isbn;          //���ʱ�׼���
		private double price;        //������һ��˽��˫���ȸ������ֶ� price �����ڴ洢ͼ��ļ۸�
		public int publisherId;     //������һ�����������ֶ� publisherd �����ڴ洢�����ID
		private String title;        //������һ��˽���ַ����ֶ� tit1e �����ڴ洢ͼ��ı���
	    //�չ��췽��
		public Titles() {       //����һ��Ĭ�ϵ�titles����

		}
	    //ȫ�ι��췽��
		public Titles(String isbn, String title, int editionnumber, String copyright, int publisherId, String imagefile,
				double price) {  //������ȫ�ι��췽����������7���������ֱ��Ӧ�����7��˽���ֶΣ����ڴ���һ������������ϸ��Ϣ�� Titles����

			this.isbn = isbn;
			this.title = title;
			this.editionnumber = editionnumber;
			this.copyright = copyright;
			this.publisherId = publisherId;
			this.imagefile = imagefile;
			this.price = price;
		}
	   //����˽���ֶεĹ�������--setter&getter() 
		public String getCopyright() {   //ÿ��˽���ֶζ���Ӧһ�������� getter���������ڻ�ȡ�ֶε�ֵ��
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

		public void setCopyright(String copyright) {  //ÿ��˽���ֶζ���Ӧһ�������� setter���������������ֶε�ֵ��
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
