package com.homeinsurance.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Vendor {
	@Id
	@GeneratedValue(generator = "vendor_gen",strategy =GenerationType.AUTO)
	@SequenceGenerator(name = "vendor_gen",sequenceName = "vendor_seq",initialValue = 200, allocationSize = 10)
	private Integer vendorId;
	@OneToOne
	private HomeInsurance homeInsurance;
	private String name;
	@OneToOne
    private Address addresss;
	public Vendor() {
		super();
	}
	
	public Vendor(String name, Address addresss) {
		super();
		this.name = name;
		this.addresss = addresss;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public HomeInsurance getHomeInsurance() {
		return homeInsurance;
	}

	public void setHomeInsurance(HomeInsurance homeInsurance) {
		this.homeInsurance = homeInsurance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddresss() {
		return addresss;
	}

	public void setAddresss(Address addresss) {
		this.addresss = addresss;
	}
	

}
