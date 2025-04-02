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
	//������һ�������� TitlesDaoImpl �����̳���BaseDao �ಢʵ���� TitlesDao ��������ζ�� TitlesDaoImpl ��̳��� BaseDao������Ժͷ��������ұ���ʵ��TitlesDao �ӿ������������з�����

	@Override
	public List<Titles> getAll() {
		List<Titles> books =new ArrayList<Titles>(); //������һ�������б� books �����ڴ洢�����ݿ��в�ѯ����ͼ�����
		//�������ݿ��������
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				//1.��������
				//2.��������
				//ǰ��������BaseDao��ʵ��
				conn=this.getConn();
				try {
					//3.дһ��SQL
					String sql="select * from titles";
					//4.ִ��SQL
					pstmt=conn.prepareStatement(sql);
					
					
					//5.�õ����������
					rs=pstmt.executeQuery();
					//5.1����
					while(rs.next()){  //ʹ�� while ѭ������ Resultset ���󣬶���ÿһ����¼������ִ�����²���:����һ���µ� Titles ����book��
						//ʹ�� Resultset����� get �����ӵ�ǰ������ȡ���ݣ�������Щ���ݸ�ֵ��Titles �������Ӧ���ԡ�����book ������ӵ� books �б���,
						//1���ɿն���
						Titles book=new Titles();
						//2��ѯ���ݿ�����Ϊ�������Ը�ֵ
						book.setIsbn(rs.getString("isbn"));
						book.setTitle(rs.getString("title"));
						book.setEditionnumber(rs.getInt("editionnumber"));
						book.setPublisherId(rs.getInt("publisherid"));
						book.setCopyright(rs.getString("copyright"));
						book.setImagefile(rs.getString("imagefile"));
						book.setPrice(rs.getDouble("price"));
						//3�Ѷ�����뵽���� 
						books.add(book);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
				//6.�ر����ݿ�
					this.closeAll(conn, pstmt, rs);  //���� BaseDao ��� closeA11 ����������������ڹر����ݿ����ӡ�
					}

		return books;     //�������ذ������� Titles ������б�
	}

	@Override
	public Titles getBookByIsbn(String isbn) { //������һ����ΪgetBookByIsbn �ķ��������ݸ�����ISBN(���ʱ�׼���)�����ݿ��м���������һ�� Titles����
		                                       //�����������һ���ַ������� isbn ����ʾҪ���ҵ�ͼ��� ISBN �š�
		Titles book=new Titles();
		//�������ݿ��������
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1.��������
		//2.��������
		//ǰ��������BaseDao��ʵ��
		conn=this.getConn();  //����BaseDao ���getconn �������������ݿ����ӡ�
		try {
			//3.дһ��SQL
			String sql="select * from titles where isbn=?";
			//4.ִ��SQL
			pstmt=conn.prepareStatement(sql); //ʹ��conn ���󴴽�һ��Preparedstatement ����������󽫰���Ԥ�����SQL��䡣
			//4.1���ã�
			pstmt.setString(1, isbn);  //����Preparedstatement �����еĲ���������Ĳ����� ISBN�����滻�� SQL����е�ռλ��?
			
			//5.�õ����������
			rs=pstmt.executeQuery(); //ִ��SQL��ѯ������һ�� Resultset ���������������˲�ѯ�����
			//5.1����
			book.setIsbn(isbn);  //Ԥ������ book �����ISBN ���ԣ���Ϊ���۲�ѯ�����Σ�ISBN������֪�ġ�
			if(rs.next()){        //ʹ�� if ����� Resultset �����Ƿ�����һ����¼������У�˵����ѯ����ƥ���ͼ�飬
				                //��ô��ʹ�� Resultset ����� get �����ӵ�ǰ������ȡ���ݣ�������Щ���ݸ�ֵ��Titles �������Ӧ���ԡ�
				
				//2��ѯ���ݿ�����Ϊ�������Ը�ֵ
				
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
		//6.�ر����ݿ�
			this.closeAll(conn, pstmt, rs);
			}

		return book; //�������� Titles ���������ѯ����ƥ��ļ�¼��
		//������󽫰���ͼ���������Ϣ:���û�в�ѯ����¼�������������Խ�ֻ�� ISBN �����ã��������Կ�����Ĭ��ֵ��
	}

}
