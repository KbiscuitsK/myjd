package com.hou.test;

import java.sql.Connection;
import java.util.List;

import com.hou.dao.TitlesDao;
import com.hou.dao.impl.TitlesDaoImpl;
import com.hou.entity.Titles;


public class TestDao {

	public static void main(String[] args) {
		  //接口   对象 =new 实现了接口的类（）
			TitlesDao dao=new TitlesDaoImpl(); //创建了一个 TitlesDao 接口的引用 dao，并将其实例化为 TitlesDaoImpl 类的一个对象。
			                                   //这意味着 dao 可以调用 TitlesDaoImpl 类中实现的 Titlespao 接口的所有方法,
			List<Titles> books=dao.getAll();   //调dao 对象的 getA11 方法，这个方法返回一个包含所有 Titles对象的列表，这些对象是从数据库中检索出来的。
			System.out.println("共查询到了"+books.size()+"本书");
			System.out.println("图书编号\t\t图书名称\t\t\t\t图书价格");  //打印出表头，用于格式化输出。
			for(Titles book:books){ //使用增强型 for循环遍历 books列表中的每个 Titles对象。
				System.out.println(book.getIsbn()+"\t"+book.getTitle()+"\t"+book.getPrice());
				//打印出每本图书的 ISBN、标题和价格。这些信息是通过调用 Titles 对象的 getIsbn,getTitle和getPrice 方法获取的。
			}
		}
}