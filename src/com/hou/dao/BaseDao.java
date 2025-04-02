package com.hou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 
 * @author ��sir
 *���ฺ�����ݿ��������ر�
 */
public class BaseDao {  //public class BaseDao :������һ����ΪBasedao �Ĺ����࣬������������Ϊ����DAO(Data Access Object)��Ļ���,�ṩ���ݿ����ӵĹ��ܡ�
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String URL="jdbc:mysql://10.2.1.190/myjd?useSSL=false";
    public static final String USER="qfisking";
    public static final String PWD="gzc2004517";
    
    public static Connection getConn(){  //����һ����ȡ���ݿ����ӵİ취
    	Connection conn=null;            //����һ��Connection����
    	try {
			//1.��������
			Class.forName(DRIVER);
			//2.��������
			conn=DriverManager.getConnection(URL,USER,PWD);
			System.out.println("�������ݿ�ɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ��");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ַ�������");
		}
    	
    	return conn;  //�������ݿ����Ӷ���
    }
    
    public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){ //������һ��������̬������������������,��̬��������ͨ������ֱ�ӵ���
    	//������һ����Ϊ closeA11 �ľ�̬���������������ǹر����ݿ����ӡ�Ԥ�������(PreparedStatement)�ͽ����(ResultSet)
    	//����ر�   �ȹ��ڲ����Դ����rs����pstmt�����ٹ�������Դ��conn������Ϊ�ڲ����Դ������������Դ
    	if(rs!=null){      //��� Resultset �����Ƿ�Ϊ nu11 ��
    		try {
    			rs.close();  //��� Resultset ����Ϊnu11 �����Թر�����
			} catch (SQLException e) {   //������ܷ����� SQLException ������ӡ��ջ���١�
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
    			System.out.println("���ݿ������ر�");
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
