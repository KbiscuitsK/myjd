package com.hou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 
 * @author 黄sir
 *此类负责数据库的连接与关闭
 */
public class BaseDao {  //public class BaseDao :定义了一个名为Basedao 的公共类，它将被用来作为其他DAO(Data Access Object)类的基础,提供数据库连接的功能。
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String URL="jdbc:mysql://10.2.1.190/myjd?useSSL=false";
    public static final String USER="qfisking";
    public static final String PWD="gzc2004517";
    
    public static Connection getConn(){  //定义一个获取数据库连接的办法
    	Connection conn=null;            //声明一个Connection对象
    	try {
			//1.加载驱动
			Class.forName(DRIVER);
			//2.创建连接
			conn=DriverManager.getConnection(URL,USER,PWD);
			System.out.println("连接数据库成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("字符串有误！");
		}
    	
    	return conn;  //返回数据库连接对象
    }
    
    public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){ //定义了一个公共静态方法，接受三个参数,静态方法可以通过类名直接调用
    	//定义了一个名为 closeA11 的静态方法，它的作用是关闭数据库连接、预处理语句(PreparedStatement)和结果集(ResultSet)
    	//返序关闭   先关内层的资源（如rs，，pstmt），再关外层的资源（conn），因为内层的资源依赖于外层的资源
    	if(rs!=null){      //检査 Resultset 对象是否不为 nu11 。
    		try {
    			rs.close();  //如果 Resultset 对象不为nu11 ，则尝试关闭它。
			} catch (SQLException e) {   //捕获可能发生的 SQLException ，并打印堆栈跟踪。
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(pstmt!=null){
    		try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(conn!=null){
    		try {
    			System.out.println("数据库正常关闭");
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
