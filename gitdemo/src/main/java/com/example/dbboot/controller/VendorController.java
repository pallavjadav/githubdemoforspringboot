package com.example.dbboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dbboot.entities.Vendor;
import com.example.dbboot.service.vendorService;

@RestController
public class VendorController {
	@Autowired
	vendorService vendorService;
	//ES_GET_ENTITYSET
		@RequestMapping("/vendor")
		public List<Vendor> getVendors(){
			
			return vendorService.readAllVendors();
		}
		
		@RequestMapping("/vendor/{vendorCode}")
		public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
			Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
			if(!searchResult.isPresent()) {
				return new Vendor((long)0,"","","","","","","");
			}
			return searchResult.get();
			
		}
		
		@PostMapping("/vendor")
		public Vendor createVendor(@RequestBody Vendor myPostBody) {
			
			return vendorService.createVendor(myPostBody);
			
		}
		
		//test using localhost:8080/vendor/search?company=SAP
		@RequestMapping("/vendor/search")
		public List<Vendor> searchByCompanyName(@RequestParam String company){
			return vendorService.searchByCompanyName(company);
		}
		//test using localhost:8080/vendor/lookup?GSTNo=123
//		@RequestMapping("/vendor/lookup")
//		public List<Vendor> lookupByGST(@RequestParam String GSTNo){
//			return vendorService.lookupVendorbyGST(GSTNo);
//		}
		
		//different request pattern
		//test using localhost:8080/vendor/lookup/123
		@RequestMapping("/vendor/lookup/{gstNo}")
		public List<Vendor> lookupByGST(@PathVariable("gstNo") String GSTNo){
			return vendorService.lookupVendorbyGST(GSTNo);
		}
		//delete operation
		@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
		public String deleteVendor(@PathVariable("id") Long Id) {
			return vendorService.deleteVendor(Id);
		}
		
		
		
		//update operation
		@RequestMapping(method=RequestMethod.PUT, value="/vendor")
		public Vendor updateVendor(@RequestBody Vendor vendor) {
			
			return vendorService.changeVendor(vendor);
			
		}
//		
	
}
