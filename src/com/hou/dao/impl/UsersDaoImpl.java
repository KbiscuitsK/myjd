package com.hou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hou.dao.BaseDao;
import com.hou.dao.UsersDao;

public class UsersDaoImpl extends BaseDao implements UsersDao {
//������1�������� UsersDaoImpl �����̳���BaseDao �ಢʵ���� usersDao ����
	@Override             //@override :����һ��ע�⣬��ʾ����ķ��� isLogin ����д�ģ������� usersDac�ӿ����Ѿ������������ṩ�����ʵ�֡�
	public boolean isLogin(String ussername, String pwd) {
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
			String sql="select u_pwd from users where u_name=?";
			//4ִ��sql�õ����
			pstmt=conn.prepareStatement(sql);  //����һ��Ԥ����������
			//4.1����?��ֵ
			pstmt.setString(1, ussername);       //����Ԥ��������еĲ����������1����SQI����еĵ�һ��?��ussername �Ƿ����Ĳ���
			rs=pstmt.executeQuery();             //ִ��SQL��ѯ������ȡ�������
			//5������
			if(rs.next()){                      //��������Ƿ�����һ�У�����У�˵����ѯ�������ݡ�
				//�����ݿ���в�ѯ����������
				String pass=rs.getString("u_pwd");
				//��ѯ����������Ҫ��ҳ�洫�ݹ���������Ƚ��Ƿ�һ��
				if(pass.equals(pwd)){ 
					ret=true;
				}
			}
		} catch (SQLException e) {         //���񲢴�ӡ�κ�SQL�쳣�Ķ�ջ����
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//6�ر����ݿ�����
			System.out.println("��¼��ϣ��ر����ݿ�ɹ�");
			this.closeAll(conn, pstmt, rs);  //����BaseDao ���е� closeA11 �������ر����ݿ����ӡ�Ԥ�������ͽ����
		}
		return ret;          //���ص�¼��֤�Ľ��:true ��ʾ��¼�ɹ���false ��ʾ��¼ʧ��
	}

}
