package com.goodfood.order_management_system.repository;

import org.springframework.data.repository.CrudRepository;

import com.goodfood.order_management_system.model.TransactionItem;

public interface TransactionItemRepository extends CrudRepository<TransactionItem,Long> {

}