package com.goodfood.order_management_system.controller.request_body;

public class TransactionItemForm {
	
	private String productCode;	
	
	private String productName;
	
	private Long quantity;

	private Long unitBasePriceTaxesExcluded;
	
	private Long totalTaxesIncluded;
	
	private Long totalDiscountTaxesIncluded;
	
	private Long totalTax;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getUnitBasePriceTaxesExcluded() {
		return unitBasePriceTaxesExcluded;
	}

	public void setUnitBasePriceTaxesExcluded(Long unitBasePriceTaxesExcluded) {
		this.unitBasePriceTaxesExcluded = unitBasePriceTaxesExcluded;
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
