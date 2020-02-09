package com.p.service.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.p.service.dao.TopicSession;
import com.p.service.exception.RestServiceException;
import com.p.service.pojo.Topic;
import com.p.service.pojo.TopicReads;
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
		Session session = null;
		Transaction tx = null;
		boolean updateSuccess = false;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			logger.debug("going to update lob" + lob);
			tx = session.beginTransaction();
			session.update(lob);
			tx.commit();
			updateSuccess = true;
		} catch (Exception e) {
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
	public List<Topic> getAll() throws RestServiceException {

		Session session = null;
		List<Topic> accounts = null;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();
			Query hqlQuery = session.createQuery("from Topic");
			accounts = hqlQuery.list();

			session.getTransaction().commit();
		} catch (Exception e) {
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return accounts;

	}

	@Override
	public Topic get(Integer id) throws RestServiceException {
		Session session = null;
		Topic accounts = null;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();

			accounts = (Topic) session.createCriteria(Topic.class).add(Restrictions.eq("id", id)).uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return accounts;
	}

	@Override
	public Topic get(String uniqueStrid) throws RestServiceException {
		Session session = null;
		Topic accounts = null;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();

			accounts = (Topic) session.createCriteria(Topic.class).add(Restrictions.eq("uniqueStrid", uniqueStrid))
					.uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return accounts;
	}

	@Override
	public boolean addRead(Topic id) throws RestServiceException {
		Session session = null;
		Topic accounts = null;
		boolean status = false;
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();

			// session.doWork(arg0);

			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

			SQLQuery sql = session
					.createSQLQuery("insert into topic_read_history (topic_id,last_read_date) values (?,?)");
			sql.setInteger(0, id.getId());
			sql.setTimestamp(1, date);
			sql.executeUpdate();

			session.getTransaction().commit();

			session.getTransaction().begin();

			SQLQuery sql1 = session.createSQLQuery("update topic set last_read_date=? where id=?");
			sql1.setTimestamp(0, date);
			sql1.setInteger(1, id.getId());
			sql1.executeUpdate();

			session.getTransaction().commit();
			status = true;
		} catch (Exception e) {
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public List<TopicReads> getReads(Topic id) throws RestServiceException {
		Session session = null;
		List<TopicReads> accounts = new ArrayList<>();
		try {
			SessionFactory hsf = HibernateSessionFactory.getSessionFactory();
			session = hsf.openSession();
			session.getTransaction().begin();

			// accounts=(Topic) session.createCriteria(Topic.class)
			// .add(Restrictions.eq("id", id))
			// .uniqueResult();

			String sql = "SELECT id, topic_id,last_read_date  FROM topic_read_history where topic_id=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setInteger(0, id.getId());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List data = query.list();

			for (Object object : data) {
				Map row = (Map) object;
				System.out.print("First Name: " + row.get("first_name"));
				System.out.println(", Salary: " + row.get("salary"));

				accounts.add(new TopicReads((Integer) row.get("id"), (Integer) row.get("topic_id"),
						(Date) row.get("last_read_date")));
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			throw new RestServiceException(e);
		} finally {
			session.close();
		}
		return accounts;
	}

}
