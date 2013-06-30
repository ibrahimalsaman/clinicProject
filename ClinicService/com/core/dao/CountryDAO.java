package com.core.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.core.beans.Clinic;
import com.core.beans.Country;
import com.core.util.HibernateUtil;

public class CountryDAO implements DAO<Country> {

	@Override
	public Country find(int id) {
		Country country = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			country = (Country) session.load(Country.class, id);
			System.out.println( country.toString());
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return country;
	}

	@Override
	public List<Country> findAll() {
		List<Country> countriesList = new ArrayList<Country>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			countriesList = session.createQuery("FROM Country").list();
			for(Iterator iterator = countriesList.iterator();iterator.hasNext();){
				Clinic clinic = (Clinic) iterator.next();
				System.out.println(clinic.toString());
			}
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return countriesList;
	}

	@Override
	public void insert(Country o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
            session.save(o);
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
			session.close();

		}		
	}

	@Override
	public void update(Country o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
            session.update(o);
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
			session.close();

		}		
	}

	@Override
	public void delete(Country o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
            session.delete(o);
			transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
			session.close();

		}		
	}
// Finders
	public Country findByName(String name) {
		Country country = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			country = (Country) session.load(Country.class, name);
			System.out.println( country.toString());
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return country;
	}
}
