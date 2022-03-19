package com.goodfood.order_management_system.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="invoice_number", length=50, nullable=false, unique=true)
	private String invoiceNumber;
	
	@Column(name="vendor_code", length=50, nullable=false)
	private String vendorCode;
	
	@Column(name="customer_code", length=50, nullable=false)
	private String customerCode;
	
    @OneToMany(mappedBy = "transaction", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<TransactionItem> transactionItems;
	
    @OneToMany(mappedBy = "transaction", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<TransactionPayment> transactionPayments;
	
	@Column(name="origin", length=25, nullable=false)
	@Enumerated(EnumType.STRING)
	private TransactionOrigin origin;
	
	@Column(name="state", length=25, nullable=false)
	@Enumerated(EnumType.STRING)
	private TransactionState state;
	
	@Column(name="transaction_created_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="transaction_logged_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date loggedAt;
	
	@Column(name="total_taxes_included", nullable=false)
	private Long totalTaxesIncluded;
	
	@Column(name="total_discount_taxes_included", nullable=false)
	private Long totalDiscountTaxesIncluded;
	
	@Column(name="total_tax", nullable=false)
	private Long totalTax;
	
	@Column(name="billing_address_street")
	private String street;
	
	@Column(name="billing_address_street_bis")
	private String streetBis;
	
	@Column(name="billing_address_city")
	private String city;
	
	@Column(name="billing_address_zipcode")
	private String zipcode;
	
	@Column(name="billing_address_countrycode")
	private String countrycode;
	
	@Column(name="billing_customer_phonenumber")
	private String phoneNumber;
	
	@Column(name="billing_customer_email")
	private String email;
	
	@Column(name="billing_customer_firstname")
	private String firstname;
	
	@Column(name="billing_customer_lastname")
	private String lastname;

	public Long getId() {
		return id;
	}

	public Set<TransactionItem> getTransactionItems() {
		return transactionItems;
	}

	public void setTransactionItems(Set<TransactionItem> transactionItems) {
		this.transactionItems = transactionItems;
	}

	public Set<TransactionPayment> getTransactionPayments() {
		return transactionPayments;
	}

	public void setTransactionPayments(Set<TransactionPayment> transactionPayments) {
		this.transactionPayments = transactionPayments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public TransactionOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(TransactionOrigin origin) {
		this.origin = origin;
	}

	public TransactionState getState() {
		return state;
	}

	public void setState(TransactionState state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLoggedAt() {
		return loggedAt;
	}

	public void setLoggedAt(Date loggedAt) {
		this.loggedAt = loggedAt;
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
