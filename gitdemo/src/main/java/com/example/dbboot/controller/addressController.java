package com.example.dbboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dbboot.entities.*;
import com.example.dbboot.service.addressService;

@RestController
public class addressController {
	
	
	@Autowired
	addressService addrSrv;

	@RequestMapping("/addresses")
	public List<address> getAddress(){
		return addrSrv.getAddress();
	}
	
	@PostMapping("/adresses")
	public address createAddress(@RequestBody address payload) {
		return addrSrv.createAddress(payload);
	}
	
	
	
	
}
