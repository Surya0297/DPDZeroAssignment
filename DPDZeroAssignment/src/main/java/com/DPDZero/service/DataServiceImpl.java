package com.DPDZero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DPDZero.model.Data;
import com.DPDZero.repository.DataRepository;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	private DataRepository dataRepo;
	
	@Override
	public Data storeData(Data data) {
		// TODO Auto-generated method stub
		return dataRepo.save(data);
		
	}

	@Override
	public Data findByKey(String key) {
		// TODO Auto-generated method stub
		return dataRepo.findByKey(key);
	}

	@Override
	public Data updateData(String key,String value) {
		// TODO Auto-generated method stub
		
		Data storedData=findByKey(key);
		if(storedData==null) return null;
		storedData.setValue(value);
		
		return dataRepo.save(storedData);
	}

	@Override
	public Data dleteData(String key) {
		// TODO Auto-generated method stub
		Data storedData=findByKey(key);
		if(storedData==null) return null;
		
		dataRepo.delete(storedData);
		return storedData;
		
	}

}
