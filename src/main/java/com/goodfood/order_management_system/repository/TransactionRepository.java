package com.goodfood.order_management_system.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodfood.order_management_system.model.Transaction;
import com.goodfood.order_management_system.model.TransactionState;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction,Long> {
	Transaction findByInvoiceNumber(String number);
	Page<Transaction> findAll(Pageable pageable);
	
    @Query("SELECT SUM(t.totalDiscountTaxesIncluded) as REVENUES, SUM(t.totalTax) as TOTAL_TAX FROM Transaction t WHERE state = ?1 AND vendorCode = ?2")
    Object[] getSalesRevenueByStateAndVendorCode(TransactionState state, String vendorCode);
}
