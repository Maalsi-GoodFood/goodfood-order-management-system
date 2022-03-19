package com.goodfood.order_management_system.repository;

import org.springframework.data.repository.CrudRepository;
import com.goodfood.order_management_system.model.InvoiceNumberIterator;


public interface InvoiceNumberIteratorRepository extends CrudRepository<InvoiceNumberIterator,Long> {
	InvoiceNumberIterator findOneByVendorCode(String vendorCode);
}
