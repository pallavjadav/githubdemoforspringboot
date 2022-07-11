package com.example.dbboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbboot.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long>{
	
	

}
