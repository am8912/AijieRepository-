package com.scheduleTest.service;

import java.util.List;

import com.scheduleTest.entity.Invoice;

public interface InvoiceService {

	Invoice findById(Integer id);
	
	List<Invoice> findAll();
	
	Invoice add(Invoice invoice);
	
	boolean deleteById(Integer id);
	
	Invoice update(Integer id, Invoice newInvoice);
}
