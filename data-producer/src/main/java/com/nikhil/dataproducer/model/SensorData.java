package com.nikhil.dataproducer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorData {
	private String id;
	private String pointId;
	private String deviceId;
	private String customer;
	private String value; 
	private String ts;
}
