package com.hou.dao;
/**
 * 
 * @author ��sir
 * �ӿ�ֻ���幦��
 * �ӿ���һ���������ͣ��������࣬���ڴ�ų��󷽷��;�̬�������ӿڲ��ܱ�ʵ�����������Ա�ʵ��(implements �ؼ���)���߼̳�(extends �ؼ���)��
 */
public interface UsersDao {  //������һ����ΪUsersDao�Ĺ����ӿ�
   //�����¼�Ĺ��� 
	public boolean isLogin(String ussername,String pwd);
	//�ڽӿ���������һ������ isLogin ����������������,�ֱ��� username(�û���)�� pwd(����)��
	//������һ�� boolean ���͵Ľ�����������ּ����֤�ṩ���û����������Ƿ�ƥ�䣬�Ӷ�ȷ���û��Ƿ���Ե�¼��
}
