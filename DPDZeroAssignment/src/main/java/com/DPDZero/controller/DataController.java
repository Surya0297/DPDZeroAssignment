package com.DPDZero.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DPDZero.model.Data;
import com.DPDZero.service.DataService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/api")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	
    @PostMapping("/data")
    public ResponseEntity<Data> storeDataHandler(@RequestBody Data data){
		System.out.println("called");
    	 Data storedData=dataService.storeData(data);
    	return new ResponseEntity<Data>(storedData, HttpStatus.CREATED);    	
    }
    
    @GetMapping("/data/{key}")
    public ResponseEntity<Object> retrieveData(@PathVariable String key) {
        // Check if the key is null or empty
        if (StringUtils.isEmpty(key)) {
            return ResponseEntity.badRequest().body("Key cannot be empty");
        }
        Data data = dataService.findByKey(key);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
        }
        
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("status", "success");
        responseData.put("data", data);
       

        // Return a success response with the retrieved data
        return ResponseEntity.ok().body(responseData);
    }
    
    @PutMapping("/data/{key}")
    public ResponseEntity<Object> updateData(@PathVariable String key, @RequestBody Map<String, String> requestBody) {
        // Check if the key is null or empty
        if (StringUtils.isEmpty(key)) {
            return ResponseEntity.badRequest().body("Key cannot be empty");
        }

        // Check if the request body contains a "value" field
        if (!requestBody.containsKey("value")) {
            return ResponseEntity.badRequest().body("Request body must contain a 'value' field");
        }

        // Retrieve data from the database based on the provided key
        Data data = dataService.updateData(key,requestBody.get("value"));

        // Check if data was found
        if (data == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
        }


        // Return a success response
        Map<String, String> responseData = new HashMap<>();
        responseData.put("status", "success");
        responseData.put("message", "Data updated successfully");
        return ResponseEntity.ok().body(responseData);
    }
    
    @DeleteMapping("/data/{key}")
    public ResponseEntity<Object> deleteData(@PathVariable String key) {
        // Check if the key is null or empty
        if (StringUtils.isEmpty(key)) {
            return ResponseEntity.badRequest().body("Key cannot be empty");
        }

        // Retrieve data from the database based on the provided key
        Data data = dataService.dleteData(key);

        // Check if data was found
        if (data == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Key not found");
        }


        // Return a success response
        Map<String, String> responseData = new HashMap<>();
        responseData.put("status", "success");
        responseData.put("message", "Data deleted successfully");
        return ResponseEntity.ok().body(responseData);
    }
	
}
