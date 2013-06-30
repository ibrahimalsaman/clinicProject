package com.core.dao;

import java.util.List;

public interface DAO<T> {
	
	public T find(int id);
	public List<T> findAll();
	public void insert(T o);
	public void update(T o);
	public void delete(T o);

}
