package com.hou.test;

import java.sql.Connection;
import java.util.List;

import com.hou.dao.TitlesDao;
import com.hou.dao.impl.TitlesDaoImpl;
import com.hou.entity.Titles;


public class TestDao {

	public static void main(String[] args) {
		  //�ӿ�   ���� =new ʵ���˽ӿڵ��ࣨ��
			TitlesDao dao=new TitlesDaoImpl(); //������һ�� TitlesDao �ӿڵ����� dao��������ʵ����Ϊ TitlesDaoImpl ���һ������
			                                   //����ζ�� dao ���Ե��� TitlesDaoImpl ����ʵ�ֵ� Titlespao �ӿڵ����з���,
			List<Titles> books=dao.getAll();   //��dao ����� getA11 �����������������һ���������� Titles������б���Щ�����Ǵ����ݿ��м��������ġ�
			System.out.println("����ѯ����"+books.size()+"����");
			System.out.println("ͼ����\t\tͼ������\t\t\t\tͼ��۸�");  //��ӡ����ͷ�����ڸ�ʽ�������
			for(Titles book:books){ //ʹ����ǿ�� forѭ������ books�б��е�ÿ�� Titles����
				System.out.println(book.getIsbn()+"\t"+book.getTitle()+"\t"+book.getPrice());
				//��ӡ��ÿ��ͼ��� ISBN������ͼ۸���Щ��Ϣ��ͨ������ Titles ����� getIsbn,getTitle��getPrice ������ȡ�ġ�
			}
		}
}