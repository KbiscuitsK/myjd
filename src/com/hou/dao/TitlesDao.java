package com.hou.dao;

import java.util.List;

import com.hou.entity.Titles;

/**
 * 
 *�ӿ���һ���������ͣ����ڶ���һ����󷽷��ļ��ϡ��ӿ��еķ���Ĭ���� public�� abstract ������ζ�����Ǳ��뱻ʵ�ֻ��߱���һ���ӿڼ̳�,
 *�˽ӿڶ���ͼ����ص�ҵ�񷽷�
 *ֻ���岻ʵ��
 * 
 */
public interface TitlesDao {
	//��ѯ����ͼ��ķ���
	public List<Titles> getAll();
	//������һ����Ϊ getA11 �ķ�������û�в���,����һ�� List<Titles>���͵Ľ��������������ڲ�ѯ���ݿ������е�ͼ����Ϣ�������Ƿ�װ��һ���б��з��ء�
	//����Isbn��ѯͼ��
	public Titles getBookByIsbn(String isbn);
	//������һ����Ϊ getBookByIsbn�ķ�����������һ���ַ������� isbn������һ�� Titles ���͵Ľ��������������ڸ����ṩ��ISBN�����ѯͼ����Ϣ
	

}
