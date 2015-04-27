package com.yoyo.dao.impl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.yoyo.cons.CommonConstant;
import com.yoyo.dao.inter.BaseDao;


public class BaseDaoImpl<T> implements BaseDao<T> {
	// DAO������г־û������ײ�������SessionFactory���
	private SessionFactory sessionFactory;

	// ����ע��SessionFactory�����setter����
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	// ����ID����ʵ��
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	// ����ʵ��
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	// ����ʵ��
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	// ɾ��ʵ��
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	// ����IDɾ��ʵ��
	public void delete(Class<T> entityClazz, Serializable id) {
		delete(get(entityClazz, id));
	}

	// ��ȡ����ʵ��
	public List<T> findAll(Class<T> entityClazz) {
		return find("from " + entityClazz.getSimpleName());
	}

	// ����HQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>) getSessionFactory().getCurrentSession()
				.createQuery(hql).list();
	}

	// ���ݴ�ռλ������HQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		// ������ѯ
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		// Ϊ����ռλ����HQL������ò���
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}
	
	protected List<T> findByPage(String hql, int pageNo,Object... params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		int pageSize = new CommonConstant().PAGE_SIZE;
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		return (List<T>) query.list();
	}
}

