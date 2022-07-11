package com.example.dbboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dbboot.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long> {
	
	List <Vendor> findByCompanyName(String companyName);

	//for custom query , can add 256 parameter
	
	@Query(nativeQuery=true, value="SELECT * from public.vendor where lower(GST_NO) like %?1% ")
	List<Vendor> lookupVendorByGST(String GSTNo);

}
