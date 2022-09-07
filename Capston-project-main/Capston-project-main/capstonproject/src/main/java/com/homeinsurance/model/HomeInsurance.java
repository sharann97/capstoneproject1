package com.homeinsurance.model;



import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class HomeInsurance {
	@Id
	@GeneratedValue(generator = "insurance_gen",strategy =GenerationType.AUTO )
	@SequenceGenerator(name = "insurance_gen",sequenceName = "insurance_seq",initialValue = 999,allocationSize = 10)
	@Column(name="insuranceId")
	private Integer insuranceId;
	private String insuranceName;
	private String category;
	private double sumAssured;
	//content,building+content,building
	private String coverage;
	//fire,earthquake,theft
	private int term;
	private double premium ;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="insurance_vendor")
	private Vendor vendor;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="homeinsurance_buyer")
	private Set<Buyer>  buyers;
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="homeInsurance_property", joinColumns = @JoinColumn(name="insurance_id"),inverseJoinColumns = @JoinColumn(name="property_Id"))
	private List<Property> properties; 
	public HomeInsurance() {
		super();
	}
	public HomeInsurance(String insuranceName, String category, double sumAssured, String coverage, int term,
			double premium, Vendor vendor, Set<Buyer> buyers, List<Property> properties) {
		super();
		this.insuranceName = insuranceName;
		this.category = category;
		this.sumAssured = sumAssured;
		this.coverage = coverage;
		this.term = term;
		this.premium = premium;
		this.vendor = vendor;
		this.buyers = buyers;
		this.properties = properties;
	}
	public Integer getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Set<Buyer> getBuyers() {
		return buyers;
	}
	public void setBuyers(Set<Buyer> buyers) {
		this.buyers = buyers;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	
	
	
	
}