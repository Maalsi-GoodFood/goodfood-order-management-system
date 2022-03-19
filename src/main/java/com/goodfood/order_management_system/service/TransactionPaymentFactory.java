package com.goodfood.order_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodfood.order_management_system.model.Transaction;
import com.goodfood.order_management_system.model.TransactionPayment;
import com.goodfood.order_management_system.repository.TransactionPaymentRepository;

@Service
public class TransactionPaymentFactory {
	
	private final TransactionPaymentRepository paymentRepository;
	
	@Autowired
	public TransactionPaymentFactory(TransactionPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	public TransactionPayment create(
		Transaction transaction,
		String method,
		Long amountPayed 
	) {
		TransactionPayment payment = new TransactionPayment();
		payment.setTransaction(transaction);
		payment.setPaymentMethod(method);
		payment.setAmountPayed(amountPayed);
		
		this.paymentRepository.save(payment);
		
		return payment;
	}
}
