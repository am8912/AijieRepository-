package com.scheduleTest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.scheduleTest.entity.Invoice;
import com.scheduleTest.repository.InvoiceRepository;
import com.scheduleTest.service.InvoiceService;

public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	// 查詢單筆
	@Override
	public Invoice findById(Integer id) {
		Optional<Invoice> optional = invoiceRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	// 查詢所有
	@Override
	public List<Invoice> findAll(){
		return invoiceRepository.findAll();
	}
	
	// 新增
	@Override
	public Invoice add(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	// 刪除
	@Override
	public boolean deleteById(Integer id) {
		Optional<Invoice> optional = invoiceRepository.findById(id);
		if(optional.isPresent()) {
			invoiceRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	// 修改
	@Override
	public Invoice update(Invoice newInvoice) {
		Optional<Invoice> optional = invoiceRepository.findById(newInvoice.getInvoiceId());
		if(optional.isPresent()) {
			Invoice invoice = optional.get();
			invoice.setOrderId(newInvoice.getOrderId());
			invoice.setInvoiceDate(newInvoice.getInvoiceDate());
			invoice.setDueDate(newInvoice.getDueDate());
			invoice.setBillingAddress(newInvoice.getBillingAddress());
			invoice.setPaymentMethod(newInvoice.getPaymentMethod());
			invoice.setSubtotal(newInvoice.getSubtotal());
			invoice.setTaxAmount(newInvoice.getTaxAmount());
			invoice.setTotalAmount(newInvoice.getTotalAmount());
			invoice.setIsPaid(newInvoice.getIsPaid());
			return invoice;
		}
		return	null;	
	}

}
