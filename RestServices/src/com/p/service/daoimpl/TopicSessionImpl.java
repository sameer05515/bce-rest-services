package com.p.service.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.p.service.dao.TopicSession;
import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Topic;
import com.p.sevice.common.HibernateSessionFactory;

public class TopicSessionImpl implements TopicSession {

	private static final Logger logger = Logger.getLogger(TopicSessionImpl.class.getName());

	@Override
	public int create(Topic topic) throws RestServiceException {
		Session session = null;
		Transaction tx = null;
		int id = 0;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			tx = session.beginTransaction();
			id = (int) session.save(topic);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error(e.getMessage(), e);
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return id;
	}
	
	@Override
	public boolean update(Topic lob) throws RestServiceException {
		Session session=null;
		Transaction tx=null;
		boolean updateSuccess=false;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			logger.debug("going to update lob"+lob);
			tx=session.beginTransaction();
			session.update(lob);
			tx.commit();
			updateSuccess=true;
		}catch(Exception e){
			tx.rollback();
			logger.error(e.getMessage(), e);
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return updateSuccess;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAll() throws RestServiceException{
		
		Session session=null;
		List<Topic> accounts=null;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();
			Query hqlQuery=session.createQuery("from Topic");
			accounts=hqlQuery.list();
			
			session.getTransaction().commit();	
		} catch (Exception e) {
			throw new RestServiceException(e); 
		} finally {
			session.close();
		}
		return accounts;
	
	}
	
	@Override
	public Topic get(Integer id) throws RestServiceException{
		Session session=null;
		Topic accounts=null;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();
			
			accounts=(Topic) session.createCriteria(Topic.class)
			.add(Restrictions.eq("id", id))
			.uniqueResult();
			
			session.getTransaction().commit();	
		} catch (Exception e) {
			throw new RestServiceException(e); 
		} finally {
			session.close();
		}
		return accounts;
	}
}

