package com.goodfood.order_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodfood.order_management_system.model.TransactionState;
import com.goodfood.order_management_system.repository.TransactionRepository;


@RestController
public class StatistiqueController {
    
	private final TransactionRepository transactionRepository;
	
	@Autowired
	public StatistiqueController(
		TransactionRepository transactionRepository
	) {
		this.transactionRepository = transactionRepository;
	}
	
	@GetMapping("/api/statistiques/sales-revenue")
	public Object[] getSalesRevenue(
		@RequestParam TransactionState state,
		@RequestParam String vendorCode
	) {
		
		
		Object[] salesRevenue = this.transactionRepository.getSalesRevenueByStateAndVendorCode(state, vendorCode);
		return salesRevenue;
		//		Map<String, Integer> response = new HashMap();
//		response.put("totalTaxesIncluded", salesRevenue.get(1).get(1));
//		response.put("totalTax", salesRevenue.get(0).get(1));
//
//		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}