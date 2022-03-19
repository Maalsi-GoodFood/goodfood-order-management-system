package com.goodfood.order_management_system.controller.request_body;

public class TransactionPaymentForm {

	private String paymentMethod;
	
	private Long amountPayed;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getAmountPayed() {
		return amountPayed;
	}

	public void setAmountPayed(Long amountPayed) {
		this.amountPayed = amountPayed;
	}
	
	
}
