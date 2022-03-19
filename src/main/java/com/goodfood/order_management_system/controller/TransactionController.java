package com.goodfood.order_management_system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodfood.order_management_system.controller.request_body.TransactionForm;
import com.goodfood.order_management_system.model.Transaction;
import com.goodfood.order_management_system.repository.TransactionRepository;
import com.goodfood.order_management_system.service.TransactionFactory;


@RestController
public class TransactionController {
    
	private final TransactionFactory transactionFactory;
	private final TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionController(
		TransactionFactory transactionFactory,
		TransactionRepository transactionRepository
	) {
		this.transactionFactory = transactionFactory;
		this.transactionRepository = transactionRepository;
	}
	
	@GetMapping("/api/transaction")
	public ResponseEntity<Map<String, Object>> getTransaction(
		@RequestParam String invoiceNumber
	) {
		Transaction transaction = this.transactionRepository.findByInvoiceNumber(invoiceNumber);
		Map<String, Object> response = new HashMap<>();
		
		response.put("transaction", transaction);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/api/transactions")
	public ResponseEntity<Map<String, Object>> getTransactions(        
		@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
	) {
		try {
			List<Transaction> transactions = new ArrayList<Transaction>();
			Pageable paging = PageRequest.of(page, size);
			
			Page<Transaction> pageTransactions;
			
			pageTransactions = this.transactionRepository.findAll(paging);
			
			transactions = pageTransactions.getContent();
			Map<String, Object> response = new HashMap<>();
			
			response.put("transactions", transactions);
			response.put("currentPage", pageTransactions.getNumber());
			response.put("totalItems", pageTransactions.getTotalElements());
			response.put("totalPages", pageTransactions.getTotalPages());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/api/transactions")
    public ResponseEntity<Map<String, String>> postTransaction(@RequestBody TransactionForm transactionData) {
				
		try {
			Transaction transaction = transactionFactory.create(
				transactionData.getVendorCode(), 
				transactionData.getCustomerCode(), 
				transactionData.getOrigin(), 
				transactionData.getState(), 
				transactionData.getCreatedAt(), 
				transactionData.getTotalTaxesIncluded(), 
				transactionData.getTotalDiscountTaxesIncluded(), 
				transactionData.getTotalTax(), 
				transactionData.getStreet(), 
				transactionData.getStreetBis(), 
				transactionData.getCity(), 
				transactionData.getZipcode(), 
				transactionData.getCountrycode(),
				transactionData.getPhoneNumber(), 
				transactionData.getEmail(), 
				transactionData.getFirstname(), 
				transactionData.getLastname(),
				transactionData.getItems(),
				transactionData.getPayments()
			);
			
		    Map<String, String> response = new HashMap<>();
		    response.put("invoiceNumber", transaction.getInvoiceNumber());
		    response.put("loggedAt", transaction.getLoggedAt().toString());
		    
		    return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@PatchMapping("/api/transaction/state")
	public ResponseEntity<Map<String, Object>> cancelTransaction(
		@RequestParam String invoiceNumber,
        @RequestParam String state		
	) {
		try {
			Transaction transaction = this.transactionRepository.findByInvoiceNumber(invoiceNumber);
			
			this.transactionFactory.updateState(transaction, state);
			
			Map<String, Object> response = new HashMap<>();
			
			this.transactionRepository.save(transaction);
			
			response.put("transaction", transaction);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}