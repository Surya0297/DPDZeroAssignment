package com.DPDZero.service;

import com.DPDZero.model.Data;

public interface DataService {
	
	public Data storeData(Data data);
	public Data findByKey(String key);
	public Data updateData(String key,String value);
	public Data dleteData(String key);
}
