package com.hou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hou.dao.BaseDao;
import com.hou.dao.TitlesDao;
import com.hou.entity.Titles;

import com.hou.dao.BaseDao;
import com.hou.dao.TitlesDao;
import com.hou.entity.Titles;

public class TitlesDaoImpl extends BaseDao implements TitlesDao {
	//定义了一个公共类 TitlesDaoImpl ，它继承了BaseDao 类并实现了 TitlesDao 接囗。这意味着 TitlesDaoImpl 类继承了 BaseDao类的属性和方法，并且必须实现TitlesDao 接口中声明的所有方法。

	@Override
	public List<Titles> getAll() {
		List<Titles> books =new ArrayList<Titles>(); //声明了一个泛型列表 books ，用于存储从数据库中查询到的图书对象。
		//定义数据库三大对象
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				//1.加载驱动
				//2.创建连接
				//前两步已在BaseDao中实现
				conn=this.getConn();
				try {
					//3.写一个SQL
					String sql="select * from titles";
					//4.执行SQL
					pstmt=conn.prepareStatement(sql);
					
					
					//5.得到结果并处理
					rs=pstmt.executeQuery();
					//5.1处理
					while(rs.next()){  //使用 while 循环遍历 Resultset 对象，对于每一条记录，都会执行以下操作:创建一个新的 Titles 对象book。
						//使用 Resultset对象的 get 方法从当前行中提取数据，并将这些数据赋值给Titles 对象的相应属性。·将book 对象添加到 books 列表中,
						//1生成空对象
						Titles book=new Titles();
						//2查询数据库表的列为对象属性赋值
						book.setIsbn(rs.getString("isbn"));
						book.setTitle(rs.getString("title"));
						book.setEditionnumber(rs.getInt("editionnumber"));
						book.setPublisherId(rs.getInt("publisherid"));
						book.setCopyright(rs.getString("copyright"));
						book.setImagefile(rs.getString("imagefile"));
						book.setPrice(rs.getDouble("price"));
						//3把对象加入到集合 
						books.add(book);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				//6.关闭数据库
					this.closeAll(conn, pstmt, rs);  //调用 BaseDao 类的 closeA11 方法，这个方法用于关闭数据库连接、
					}

		return books;     //方法返回包含所有 Titles 对象的列表。
	}

	@Override
	public Titles getBookByIsbn(String isbn) { //定义了一个名为getBookByIsbn 的方法它根据给定的ISBN(国际标准书号)从数据库中检索并返回一个 Titles对象。
		                                       //这个方法接受一个字符串参数 isbn ，表示要査找的图书的 ISBN 号。
		Titles book=new Titles();
		//定义数据库三大对象
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1.加载驱动
		//2.创建连接
		//前两步已在BaseDao中实现
		conn=this.getConn();  //调用BaseDao 类的getconn 方法来建立数据库连接。
		try {
			//3.写一个SQL
			String sql="select * from titles where isbn=?";
			//4.执行SQL
			pstmt=conn.prepareStatement(sql); //使用conn 对象创建一个Preparedstatement 对象，这个对象将包含预编译的SQL语句。
			//4.1设置？
			pstmt.setString(1, isbn);  //设置Preparedstatement 对象中的参数，这里的参数是 ISBN，它替换了 SQL语句中的占位符?
			
			//5.得到结果并处理
			rs=pstmt.executeQuery(); //执行SQL查询并返回一个 Resultset 对象，这个对象包含了查询结果。
			//5.1处理
			book.setIsbn(isbn);  //预先设置 book 对象的ISBN 属性，因为无论查询结果如何，ISBN都是已知的。
			if(rs.next()){        //使用 if 语句检查 Resultset 对象是否有下一个记录。如果有，说明查询到了匹配的图书，
				                //那么将使用 Resultset 对象的 get 方法从当前行中提取数据，并将这些数据赋值给Titles 对象的相应属性。
				
				//2查询数据库表的列为对象属性赋值
				
				book.setTitle(rs.getString("title"));
				book.setEditionnumber(rs.getInt("editionnumber"));
				book.setPublisherId(rs.getInt("publisherid"));
				book.setCopyright(rs.getString("copyright"));
				book.setImagefile(rs.getString("imagefile"));
				book.setPrice(rs.getDouble("price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//6.关闭数据库
			this.closeAll(conn, pstmt, rs);
			}

		return book; //方法返回 Titles 对象。如果查询到了匹配的记录，
		//这个对象将包含图书的所有信息:如果没有查询到记录，这个对象的属性将只有 ISBN 被设置，其他属性可能是默认值。
	}

}
