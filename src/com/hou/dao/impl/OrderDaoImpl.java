package com.hou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hou.dao.BaseDao;
import com.hou.dao.OrderDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public boolean isWriteOrder(String resaver, String phone, String addr, String zipcode, String card) {
		boolean ret=false;  //����һ����������ret���ڴ洢��¼��֤�Ľ������ʼ��ֵΪ false.
		//ǰ���Ƿ����ȶ������ݿ��������
		Connection conn=null;          //������Connection ����conn �����ڴ洢���ݿ����ӣ���ʼֵΪ nu11��
		PreparedStatement pstmt=null;  //������Preparedstatement����pstmt�����ڴ洢Ԥ����SQL��䣬��ʼֵΪ nu11��
		ResultSet rs=null;             //������Resultset ����rs�����ڴ洢��ѯ���������ʼֵΪ nu11 ��
		//JDBC6����
		//1��������
		//2��������
		//������д�ã���������
		conn=this.getConn();              //��BaseDao���е� getconn ��������ȡ���ݿ�����,
		try {
			//3дһ��SQL
			String sql="insert into bookorder(resaver,phone,addr,zipcode,card) values(?,?,?,?,?)";
			//4ִ��sql�õ����
			pstmt=conn.prepareStatement(sql);  //����һ��Ԥ����������
			//4.1����?��ֵ
			pstmt.setString(1, resaver);       //����Ԥ��������еĲ����������1����SQI����еĵ�һ��?��ussername �Ƿ����Ĳ���
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			pstmt.setString(4, zipcode);
			pstmt.setString(5, card);
			
			int num=pstmt.executeUpdate();             //ִ��SQL��ѯ������ȡ�������
			//5������
			if(num!=0){                      //��������Ƿ�����һ�У�����У�˵����ѯ�������ݡ�
				ret=true;
			}
		} catch (SQLException e) {         //���񲢴�ӡ�κ�SQL�쳣�Ķ�ջ����
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//6�ر����ݿ�����
			System.out.println("��¼��ϣ��ر����ݿ�ɹ�");
			this.closeAll(conn, pstmt, rs);  //����BaseDao ���е� closeA11 �������ر����ݿ����ӡ�Ԥ�������ͽ����
		}
		return ret;    
	}

}
