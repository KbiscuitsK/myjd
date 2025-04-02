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
			String sql="update account set balance = balance-? where card=?";
			//4ִ��sql�õ����
			pstmt=conn.prepareStatement(sql);  //����һ��Ԥ����������
			//4.1����?��ֵ
			pstmt.setDouble(1, total);       //����Ԥ��������еĲ����������1����SQI����еĵ�һ��?��ussername �Ƿ����Ĳ���
			pstmt.setString(2, card);
			
			
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
