package com.goodfood.order_management_system.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodfood.order_management_system.controller.request_body.TransactionItemForm;
import com.goodfood.order_management_system.controller.request_body.TransactionPaymentForm;
import com.goodfood.order_management_system.model.Transaction;
import com.goodfood.order_management_system.model.TransactionItem;
import com.goodfood.order_management_system.model.TransactionOrigin;
import com.goodfood.order_management_system.model.TransactionPayment;
import com.goodfood.order_management_system.model.TransactionState;
import com.goodfood.order_management_system.repository.TransactionRepository;

@Service
public class TransactionFactory {
	
	private final InvoiceNumberGenerator numberGenerator;
	private final TransactionRepository transactionRepository;
	private final TransactionItemFactory itemFactory;
	private final TransactionPaymentFactory paymentFactory;
	
	@Autowired
	public TransactionFactory(
		InvoiceNumberGenerator numberGenerator,
		TransactionRepository transactionRepository,
		TransactionItemFactory itemFactory,
		TransactionPaymentFactory paymentFactory
	) {
		this.numberGenerator = numberGenerator;
		this.transactionRepository = transactionRepository;
		this.itemFactory = itemFactory;
		this.paymentFactory = paymentFactory;
	}
	
	public Transaction create(
		String vendorCode,
		String customerCode,
		String origin,
		String state,
		String transactionCreatedAt,
		Long totalTaxesIncluded,
		Long totalDiscountTaxesIncluded,
		Long totalTax,
		String street,
		String streetBis,
		String city,
		String zipcode,
		String countrycode,
		String phonenumber,
		String email,
		String firstname,
		String lastname,
		Set<TransactionItemForm> transactionItems,
		Set<TransactionPaymentForm> transactionPayments
	) throws Exception {
		Transaction transaction = new Transaction();
		
		String transactionNumber = numberGenerator.generateNext(vendorCode);
		
		Date createdAt;
		
		try {
			createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(transactionCreatedAt);
			transaction.setCreatedAt(createdAt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		transaction.setInvoiceNumber(transactionNumber);
		transaction.setVendorCode(vendorCode);
		transaction.setCustomerCode(customerCode);
		transaction.setOrigin(TransactionOrigin.WEB_APPLICATION);
		transaction.setTotalTaxesIncluded(totalTaxesIncluded);
		transaction.setTotalDiscountTaxesIncluded(totalDiscountTaxesIncluded);
		transaction.setTotalTax(totalTax);
		transaction.setStreet(street);
		transaction.setStreetBis(streetBis);
		transaction.setCity(city);
		transaction.setZipcode(zipcode);
		transaction.setCountrycode(countrycode);
		transaction.setPhoneNumber(phonenumber);
		transaction.setEmail(email);
		transaction.setFirstname(firstname);
		transaction.setLastname(lastname);
		transaction.setLoggedAt(new Date());
		
		transaction = this.updateState(transaction, state);
		
		this.transactionRepository.save(transaction);
		
		for(TransactionItemForm item : transactionItems) {
			TransactionItem transactionItem = this.itemFactory.create(
				transaction,
				item.getProductCode(),
				item.getProductName(),
				item.getQuantity(),
				item.getUnitBasePriceTaxesExcluded(),
				item.getTotalTaxesIncluded(),
				item.getTotalDiscountTaxesIncluded(),
				item.getTotalTax()
			);
		}
		
		for(TransactionPaymentForm payment : transactionPayments) {
			TransactionPayment transactionPayment = this.paymentFactory.create(
				transaction,
				payment.getPaymentMethod(),
				payment.getAmountPayed()
			);
		}
			
		this.transactionRepository.save(transaction);
		
		return transaction;
	}
	
	public Transaction updateState(Transaction transaction, String state) throws Exception
	{
		switch(state) {
			case "CANCELED":
				transaction.setState(TransactionState.CANCELED);
				break;
			case "PROCESSING":
				transaction.setState(TransactionState.PROCESSING);
				break;
			case "COMPLETED":
				transaction.setState(TransactionState.COMPLETED);
				break;
			default:
				throw new Exception("Invalid transaction state given");
		}
		return transaction;
	}
}
	