package com.DPDZero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPDZero.model.Data;

public interface DataRepository extends JpaRepository<Data, Long>{
	
	public Data findByKey(String key);

}
