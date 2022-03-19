package com.goodfood.order_management_system.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodfood.order_management_system.model.InvoiceNumberIterator;
import com.goodfood.order_management_system.repository.InvoiceNumberIteratorRepository;
import com.goodfood.order_management_system.repository.TransactionRepository;

@Service
public class InvoiceNumberGenerator {
	
	private final InvoiceNumberIteratorRepository numberRepository;
	private final TransactionRepository transactionRepository;
	
	private static final String template = "%s%s%s"; //vvvvvyyyymmdd00000000
	
	@Autowired
	public InvoiceNumberGenerator(
		InvoiceNumberIteratorRepository numberRepository,
		TransactionRepository transactionRepository
	) {
		this.numberRepository = numberRepository;
		this.transactionRepository = transactionRepository;
	}
	
	public String generateNext(String vendorCode) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
		Date date = new Date(System.currentTimeMillis());
		
		InvoiceNumberIterator iterator = numberRepository.findOneByVendorCode(vendorCode);

		if(iterator == null) {
			iterator = this.initIterator(vendorCode);
		}
		
		String number;
		boolean transactionExist = false;
		
		do {
			String incrementation = String.format("%08d", iterator.getCounter());
			iterator.increment();	
			
			number = String.format(template, vendorCode, formatter.format(date), incrementation);
			transactionExist = transactionRepository.findByInvoiceNumber(number) != null;
		} while (transactionExist);
		
		numberRepository.save(iterator);
		
		return number;
	}
	
	public InvoiceNumberIterator initIterator(String vendorCode) {
		InvoiceNumberIterator iterator = new InvoiceNumberIterator();
		
		iterator.setCounter(0);
		iterator.setVendorCode(vendorCode);
		
		numberRepository.save(iterator);
		
		return iterator;
	}
}
