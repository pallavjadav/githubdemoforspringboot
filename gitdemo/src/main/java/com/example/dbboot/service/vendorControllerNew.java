package com.example.dbboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 

import com.example.dbboot.entities.Vendor;

@RepositoryRestResource(collectionResourceRel="vendor", path="newVendor")
public interface vendorControllerNew extends JpaRepository<Vendor, String> {

}
 