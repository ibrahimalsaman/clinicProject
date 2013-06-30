package com.core.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.core.beans.Patient;
import com.core.util.HibernateUtil;

public class PatientDAO implements DAO<Patient> {

	@Override
	public Patient find(int id) {
		Patient patient = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			patient = (Patient) session.load(Patient.class, id);
			System.out.println(patient.toString());
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> patientsList = new ArrayList<Patient>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			patientsList = session.createQuery("FROM Patient").list();
			for(Iterator iterator = patientsList.iterator();iterator.hasNext();){
				Patient patient = (Patient) iterator.next();
				System.out.println(patient.toString());
			}
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return patientsList;
	}

	@Override
	public void insert(Patient o) {
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
	public void update(Patient o) {
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
	public void delete(Patient o) {
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
	
	public Patient findByFirstName(String firstName) {
		Patient patient = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			patient = (Patient) session.load(Patient.class, firstName);
			System.out.println(patient.toString());
		}catch (HibernateException e){
			e.printStackTrace();	
			session.close();

		}
		return patient;
	}

}
