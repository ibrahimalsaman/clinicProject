package com.core.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.core.beans.Clinic;
import com.core.beans.State;
import com.core.util.HibernateUtil;

public class StateDAO implements DAO<State> {

	@Override
	public State find(int id) {
		State state = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			state = (State) session.load(State.class, id);
			System.out.println( state.toString());
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return state;
	}

	@Override
	public List<State> findAll() {
		List<State>  statesList = new ArrayList<State>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			statesList = session.createQuery("FROM State").list();
			for(Iterator iterator = statesList.iterator();iterator.hasNext();){
				State state = (State) iterator.next();
				System.out.println(state.toString());
			}
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return statesList;
	}

	@Override
	public void insert(State o) {
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
	public void update(State o) {
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
	public void delete(State o) {
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

}
