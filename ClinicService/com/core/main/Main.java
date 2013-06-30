package com.core.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.core.beans.Clinic;
import com.core.dao.ClinicDAO;
import com.core.util.HibernateUtil;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClinicDAO clinicDAO = new ClinicDAO();
//		Clinic clinic = new Clinic();
//		clinic.setName("Reham Alsaman Clinic");
//		clinic.setLandPhone("023210783");
//		clinic.setMobilePhone("011111111111");
//		clinic.setEmail("rora.alsaman@gmail.com");
//		clinic.setWebsite("rora@eb2a.com");
//		clinic.setAddress("souhag");
//		clinicDAO.insert(clinic);
		
//		clinic.setId( 7);
//		clinicDAO.delete(clinic);
		
		
//		clinic.setId((long) 1);
//		clinic.setName("ahmed clinic");
//		clinic.setMobilePhone("010101010");
//		clinic.setLandPhone("252525");
//		clinic.setEmail("medo@yahoo.com");
//		clinic.setAddress("Maadi");
//		clinic.setWebsite("non");
//		clinicDAO.update(clinic);
		
//		clinicDAO.find(10);
		
//		clinicDAO.findAll();
		
//		clinicDAO.findByMobilePhone("11111111");
		clinicDAO.findByEmail("yahoo");
//		clinicDAO.findByName("alsa");
		
//		Main obj = new Main();
//		Long clinicId = obj.saveClinic("Alsaman Clinic");
//		Long clinicId1 = obj.saveClinic("Alsaman1 Clinic");
//		Long clinicId2 = obj.saveClinic("Alsaman2 Clinic");
//		obj.listClinic();
//		obj.updateClinic(clinicId1, "Alsamanfirst");
//		obj.deleteClinic(clinicId2);
//		obj.listClinic();
	}
//	
//	public Long saveClinic (String clinicName){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//		Long clinicId = null;
//		try{
//			transaction = session.beginTransaction();
//			Clinic clinic = new Clinic();
//			clinic.setName(clinicName);
//			clinicId = (Long) session.save(clinic);
//			transaction.commit();
//		}catch(HibernateException e){
//			transaction.rollback();
//			e.printStackTrace();
//		}finally{
//			session.close();
//		}
//		return clinicId;
//	}
//	public void listClinic(){
//		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//		try{
//			transaction = session.beginTransaction();
//			List clinics = session.createQuery("FROM Clinic").list();
//			for(Iterator iterator = clinics.iterator();iterator.hasNext();){
//				Clinic clinic = (Clinic) iterator.next();
//				System.out.println(clinic.getName());
//			}
//			transaction.commit();
//		}catch (HibernateException e){
//			transaction.rollback();
//			e.printStackTrace();
//		}finally{
//			session.close();
//		}
//	}
//	
//	public void updateClinic(Long clinicId, String clinicName){
//	
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//		try{
//			transaction = session.beginTransaction();
//			Clinic clinic = (Clinic) session.get(Clinic.class, clinicId);
//			clinic.setName(clinicName);
//			transaction.commit();
//	}catch(HibernateException e){
//		transaction.rollback();
//		e.printStackTrace();
//		session.close();
//	}
//	}
//	
//	public void deleteClinic(Long clinicId){
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//		try{
//			transaction = session.beginTransaction();
//			Clinic clinic = (Clinic) session.get(Clinic.class, clinicId);
//			session.delete(clinic);
//			transaction.commit();
//		}catch(HibernateException e){
//			transaction.rollback();
//		}finally{
//			session.close();
//		}
//	}
}
