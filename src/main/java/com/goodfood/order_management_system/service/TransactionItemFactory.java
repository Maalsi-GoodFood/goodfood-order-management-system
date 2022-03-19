package com.goodfood.order_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodfood.order_management_system.model.Transaction;
import com.goodfood.order_management_system.model.TransactionItem;
import com.goodfood.order_management_system.repository.TransactionItemRepository;

@Service
public class TransactionItemFactory {

	private final TransactionItemRepository itemRepository;
	
	@Autowired
	public TransactionItemFactory(TransactionItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public TransactionItem create(
		Transaction transaction,
		String productCode,
		String productName,
		Long quantity,
		Long unitBasePriceTaxesExcluded,
		Long totalTaxesIncluded,
		Long totalDiscountTaxesIncluded,
		Long totalTax
	) {
		TransactionItem item = new TransactionItem();
		
		item.setTransaction(transaction);
		item.setProductCode(productCode);
		item.setProductName(productName);
		item.setQuantity(quantity);
		item.setUnitBasePriceTaxesExcluded(unitBasePriceTaxesExcluded);
		item.setTotalTaxesIncluded(totalTaxesIncluded);
		item.setTotalDiscountTaxesIncluded(totalDiscountTaxesIncluded);
		item.setTotalTax(totalTax);
		
		this.itemRepository.save(item);
		
		return item;
	}
}
