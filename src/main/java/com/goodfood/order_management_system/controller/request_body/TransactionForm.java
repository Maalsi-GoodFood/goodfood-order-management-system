package com.goodfood.order_management_system.controller.request_body;

import java.util.Set;

public class TransactionForm {

	private String vendorCode;
	
	private String customerCode;
	
	private String origin;
	
	private String state;
	
	private String createdAt;
	
	private Long totalTaxesIncluded;
	
	private Long totalDiscountTaxesIncluded;
	
	private Long totalTax;

	private String street;
	
	private String streetBis;
	
	private String city;
	
	private String zipcode;
	
	private String countrycode;
	
	private String phoneNumber;
	
	private String email;
	
	private String firstname;
	
	private String lastname;
	
	private Set<TransactionItemForm> items;
	
	private Set<TransactionPaymentForm> payments;
	
	public Set<TransactionPaymentForm> getPayments() {
		return payments;
	}

	public void setPayments(Set<TransactionPaymentForm> payments) {
		this.payments = payments;
	}

	public Set<TransactionItemForm> getItems() {
		return items;
	}

	public void setItems(Set<TransactionItemForm> items) {
		this.items = items;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Long getTotalTaxesIncluded() {
		return totalTaxesIncluded;
	}

	public void setTotalTaxesIncluded(Long totalTaxesIncluded) {
		this.totalTaxesIncluded = totalTaxesIncluded;
	}

	public Long getTotalDiscountTaxesIncluded() {
		return totalDiscountTaxesIncluded;
	}

	public void setTotalDiscountTaxesIncluded(Long totalDiscountTaxesIncluded) {
		this.totalDiscountTaxesIncluded = totalDiscountTaxesIncluded;
	}

	public Long getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Long totalTax) {
		this.totalTax = totalTax;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetBis() {
		return streetBis;
	}

	public void setStreetBis(String streetBis) {
		this.streetBis = streetBis;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
