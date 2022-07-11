package com.example.dbboot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VENDOR")
public class Vendor {

	@Id
	@Column(nullable = false, name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(nullable = false, name = "COMPANY_NAME")
	public String companyName;
	@Column(nullable = false, name = "FIRST_NAME")
	public String contactName;
	@Column(nullable = false, name = "LAST_NAME")
	public String lastName;
	@Column(nullable = false, name = "WEBSITE")
	public String website;
	@Column(nullable = false, name = "EMAILID")
	public String email;
	@Column(nullable = false, name = "STATUS")
	public String status;
	@Column(nullable = false, name = "GST_NO")
	public String gstNo;

	//Association of one to many (one vendor have many address relationship) 1..N 
 	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="vendor" , referencedColumnName ="ID" )
	private List<address> addresses = new ArrayList<>();
	//DO NOT forget to add setters and getters method for association 
	
	public List<address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<address> addresses) {
		this.addresses = addresses;
	}

	public Vendor() {
	}

	public Vendor(Long id, String companyName, String contactName, String lastName, String website, String email,
			String status, String gstNo) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.contactName = contactName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

}
