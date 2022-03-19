package com.goodfood.order_management_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transaction_item")
public class TransactionItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id", nullable = false)
	@JsonBackReference
    private Transaction transaction;
	
	@Column(name="product_code", length=50, nullable=false)
	private String productCode;	
	
	@Column(name="product_name", length=255, nullable=false)
	private String productName;
	
	@Column(name="quantity", nullable=false)
	private Long quantity;

	@Column(name="unit_base_price_taxes_excluded", nullable=false)
	private Long unitBasePriceTaxesExcluded;
	
	@Column(name="total_taxes_included", nullable=false)
	private Long totalTaxesIncluded;
	
	@Column(name="total_discount_taxes_included", nullable=false)
	private Long totalDiscountTaxesIncluded;
	
	@Column(name="total_tax", nullable=false)
	private Long totalTax;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getUnitBasePriceTaxesExcluded() {
		return unitBasePriceTaxesExcluded;
	}

	public void setUnitBasePriceTaxesExcluded(Long unitBasePriceTaxesExcluded) {
		this.unitBasePriceTaxesExcluded = unitBasePriceTaxesExcluded;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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
}
