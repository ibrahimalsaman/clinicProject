package com.core.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ItalicAction;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.core.beans.Clinic;
import com.core.util.HibernateUtil;

public class ClinicDAO implements DAO<Clinic> {

	//constant
	Clinic clinic = null;
	Transaction transaction = null;
	Iterator iterator = null;
	Session session = HibernateUtil.getSessionFactory().openSession();
	Criteria criteria = session.createCriteria(Clinic.class);

	@Override
	public Clinic find(int id) {
		transaction = session.beginTransaction();
		try {
			clinic = (Clinic) session.load(Clinic.class, id);
			System.out.println(clinic.toString());
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return clinic;

	}

	@Override
	public List<Clinic> findAll() {
		List<Clinic> clinicList = new ArrayList<Clinic>();
		transaction = session.beginTransaction();
		try {

			clinicList = session.createQuery("FROM Clinic").list();
			for (iterator = clinicList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());

			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return clinicList;

	}

	@Override
	public void insert(Clinic o) {
		transaction = session.beginTransaction();

		try {
			session.save(o);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
	}

	@Override
	public void update(Clinic o) {
		transaction = session.beginTransaction();
		try {
			session.update(o);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
	}

	@Override
	public void delete(Clinic o) {
		transaction = session.beginTransaction();
		try {
			session.delete(o);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
	}

	// Finders

	public Clinic findByName(String name) {
		transaction = session.beginTransaction();
		try {
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
			List clinicList = criteria.list();
			for (iterator = clinicList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return clinic;

	}

	public Clinic findByMobilePhone(String mobilePhone) {
		transaction = session.beginTransaction();
		try {

			criteria.add(Restrictions.like("mobilePhone", mobilePhone,
					MatchMode.ANYWHERE));
			List clinicsList = criteria.list();

			for (iterator = clinicsList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.print(clinic.toString() + "\n");
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return clinic;
	}

	public Clinic findByLandPhone(String landPhone) {
		transaction = session.beginTransaction();
		try {
			criteria.add(Restrictions.like("landPhone", landPhone,
					MatchMode.ANYWHERE));
			List clinicsList = criteria.list();
			for (iterator = clinicsList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return clinic;
	}

	public Clinic findByEmail(String email) {
		transaction = session.beginTransaction();
		try {
			criteria.add(Restrictions.like("email", email, MatchMode.ANYWHERE));
			List clinics = criteria.list();

			for (Iterator iterator = clinics.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return clinic;
	}

	public Clinic findByWebsite(String website) {
		transaction = session.beginTransaction();
		try {
			criteria.add(Restrictions.like("website", website,
					MatchMode.ANYWHERE));
			List clinicsList = criteria.list();
			for (iterator = clinicsList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return clinic;
	}

	public Clinic findByMinistryNumber(String ministryNumber) {
		transaction = session.beginTransaction();
		try {
			criteria.add(Restrictions.like("ministryNumber", ministryNumber,
					MatchMode.ANYWHERE));
			List clinicsList = criteria.list();
			for (iterator = clinicsList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return clinic;
	}

	public Clinic findByCityId(int cityId) {
		transaction = session.beginTransaction();
		try {
			criteria.add(Restrictions.eq("cityId", cityId));
			List clinicsList = criteria.list();
			for (iterator = clinicsList.iterator(); iterator.hasNext();) {
				clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}
		return clinic;
	}

}
