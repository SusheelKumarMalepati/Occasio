package com.in.entity;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
@Configuration
public class EpochTime {
	public long epoch() {
		Date currentDateTime=new Date();
		long epoch=(long) (currentDateTime.getTime()/1000.0);
		return epoch;
	}	
}
