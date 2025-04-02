package com.hou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hou.dao.AccountDao;
import com.hou.dao.BaseDao;

public class AccountDaoImpl extends BaseDao implements AccountDao {

	@Override
	public boolean isPay(String card, double total) {
		boolean ret=false;  //声明一个布尔变量ret用于存储登录验证的结果，初始量值为 false.
		//前提是方法先定义数据库三大对象
		Connection conn=null;          //声明个Connection 变量conn ，用于存储数据库连接，初始值为 nu11。
		PreparedStatement pstmt=null;  //声明个Preparedstatement变量pstmt，用于存储预处理SQL语句，初始值为 nu11。
		ResultSet rs=null;             //声明个Resultset 变量rs，用于存储查询结果集，初始值为 nu11 。
		//JDBC6步骤
		//1加载驱动
		//2创建连接
		//父类已写好，拿来就用
		conn=this.getConn();              //调BaseDao类中的 getconn 方法来获取数据库连接,
		try {
			//3写一个SQL
			String sql="update account set balance = balance-? where card=?";
			//4执行sql得到结果
			pstmt=conn.prepareStatement(sql);  //创建一个预处理语句对象。
			//4.1设置?的值
			pstmt.setDouble(1, total);       //设置预处理语句中的参数，这里的1代表SQI语句中的第一个?，ussername 是方法的参数
			pstmt.setString(2, card);
			
			
			int num=pstmt.executeUpdate();             //执行SQL查询，并获取结果集。
			//5处理结果
			if(num!=0){                      //检查结果集是否有下一行，如果有，说明查询到了数据。
				ret=true;
			}
		} catch (SQLException e) {         //捕获并打印任何SQL异常的堆栈跟踪
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//6关闭数据库连接
			System.out.println("登录完毕，关闭数据库成功");
			this.closeAll(conn, pstmt, rs);  //调用BaseDao 类中的 closeA11 方法来关闭数据库连接、预处理语句和结果集
		}
		return ret;   
	}

}
