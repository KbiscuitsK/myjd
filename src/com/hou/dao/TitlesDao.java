package com.hou.dao;

import java.util.List;

import com.hou.entity.Titles;

/**
 * 
 *接口是一种引用类型，用于定义一组抽象方法的集合。接口中的方法默认是 public和 abstract 的这意味着它们必须被实现或者被另一个接口继承,
 *此接口定义图书相关的业务方法
 *只定义不实现
 * 
 */
public interface TitlesDao {
	//查询所有图书的方法
	public List<Titles> getAll();
	//声明了一个名为 getA11 的方法，它没有参数,返回一个 List<Titles>类型的结果。这个方法用于查询数据库中所有的图书信息并将它们封装在一个列表中返回。
	//根据Isbn查询图书
	public Titles getBookByIsbn(String isbn);
	//声明了一个名为 getBookByIsbn的方法，它接受一个字符串参数 isbn，返回一个 Titles 类型的结果。这个方法用于根据提供的ISBN号码查询图书信息
	

}
