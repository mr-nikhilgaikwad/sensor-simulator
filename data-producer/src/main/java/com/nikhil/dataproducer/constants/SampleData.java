package com.nikhil.dataproducer.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nikhil.dataproducer.common.Util;
import com.nikhil.dataproducer.model.SensorData;

@Component
public class SampleData {
	private Random random = new Random();
	private static Map<String, String[]> SENSOR_DATA_MAP = new HashMap<>();
	private static List<String> keys = new ArrayList<>();
	static {
		SENSOR_DATA_MAP.put("e63f65d2-3e8a-4ec6-a466-4dd165242a15", new String[]{"device-001", "cust-01"});
		SENSOR_DATA_MAP.put("51d065f5-a320-4cb3-8c3e-2115845d0e92", new String[]{"device-001", "cust-01"});
		SENSOR_DATA_MAP.put("6ab5d13e-14cc-47da-9ea9-900e98a246c7", new String[]{"device-001", "cust-01"});
		SENSOR_DATA_MAP.put("2885bdc6-a0a9-4e54-a0f6-96b56a059e7b", new String[]{"device-002", "cust-01"});
		SENSOR_DATA_MAP.put("5d1e4a0d-750c-451a-b13b-3c3ec7b260c5", new String[]{"device-002", "cust-01"});
		SENSOR_DATA_MAP.put("480e3084-5040-461b-92af-d1176590815d", new String[]{"device-003", "cust-02"});
		SENSOR_DATA_MAP.put("1135685c-6358-4abf-8f8c-b8cf05a104de", new String[]{"device-003", "cust-02"});
		SENSOR_DATA_MAP.put("5de45f04-3168-4c64-96bc-42d0a22eb840", new String[]{"device-003", "cust-02"});
		SENSOR_DATA_MAP.put("9f084f44-e64c-40cd-9d70-8b6d07eebcf0", new String[]{"device-004", "cust-02"});
		SENSOR_DATA_MAP.put("b725dd51-1125-4e19-b38d-e730b2e24cc4", new String[]{"device-004", "cust-02"});
	
		keys = new ArrayList<>(SENSOR_DATA_MAP.keySet());
	}
	
	public SensorData getSample() { 
		keys.get(random.nextInt(keys.size()));
		var currentKey = keys.get(random.nextInt(keys.size()));
		
		var data = new SensorData();
		data.setPointId(currentKey);
		data.setDeviceId(SENSOR_DATA_MAP.get(currentKey)[0]);
		data.setCustomer(SENSOR_DATA_MAP.get(currentKey)[1]);
		data.setValue(String.valueOf(random.nextInt(100)));
		data.setTs(Util.getISODate());
		data.setId(UUID.randomUUID().toString());
		
		
		return data;
	}
}
