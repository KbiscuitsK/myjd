package com.hou.dao;
/**
 * 
 * @author 黄sir
 * 接口只定义功能
 * 接口是一种引用类型，类似于类，用于存放抽象方法和静态常量。接口不能被实例化，但可以被实现(implements 关键字)或者继承(extends 关键字)。
 */
public interface UsersDao {  //定义了一个名为UsersDao的公共接口
   //定义登录的功能 
	public boolean isLogin(String ussername,String pwd);
	//在接口中声明了一个方法 isLogin ，它接受两个参数,分别是 username(用户名)和 pwd(密码)，
	//并返回一个 boolean 类型的结果。这个方法旨在验证提供的用户名和密码是否匹配，从而确定用户是否可以登录。
}
