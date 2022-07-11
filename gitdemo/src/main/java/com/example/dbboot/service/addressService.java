package com.example.dbboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.dbboot.entities.*;

@Component
public class addressService {

	@Autowired
	IAddressPersistence address;
	

	
	public List<address> getAddress(){
		return address.findAll();
	}
	

	public address createAddress(address payload) {
		return address.save(payload);
	}
}
