package com.core.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.core.beans.City;
import com.core.util.HibernateUtil;

public class CityDAO implements DAO<City> {

	@Override
	public City find(int id) {
		City city = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			city = (City) session.load(City.class, id);
			System.out.println(city.toString());
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		return city;
	}

	@Override
	public List<City> findAll() {
		List<City> citiesList = new ArrayList<City>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			citiesList = session.createQuery("FROM City").list();
			for(Iterator iterator = citiesList.iterator();iterator.hasNext();){
				City city = (City) iterator.next();
				System.out.println(city.toString());
			}
		} catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		return citiesList;
	}

	@Override
	public void insert(City o) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(o);
			transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
	}

	@Override
	public void update(City o) {
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
	public void delete(City o) {
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
	public City findByStateId(int stateId) {
		City city = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			city = (City) session.load(City.class, stateId);
			System.out.println(city.toString());
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		return city;
	}
	public City findByName(String name) {
		City city = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			city = (City) session.load(City.class, name);
			System.out.println(city.toString());
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		return city;
	}
	

}
