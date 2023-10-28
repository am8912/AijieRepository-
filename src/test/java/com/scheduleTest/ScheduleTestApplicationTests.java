package com.scheduleTest;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scheduleTest.entity.Invoice;
import com.scheduleTest.repository.InvoiceRepository;

@SpringBootTest
class ScheduleTestApplicationTests {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Test
	void contextLoads() {
//		Invoice invoice = new Invoice();
//		invoice.setOrderId(3);
//		invoice.setInvoiceDate(new Date());
//		Date dueDate = new Date(2023,12,20);
//		invoice.setDueDate(dueDate);
//		invoice.setBillingAddress("台南西區");
//		invoice.setPaymentMethod("現金");
//		invoice.setSubtotal(990.0);
//		invoice.setTaxAmount(2.2);
//		invoice.setTotalAmount(992.0);
//		invoice.setIsPaid("0");
//		invoiceRepository.save(invoice);
//		invoiceRepository.deleteById(1);
		
//		Optional<Invoice> optional = invoiceRepository.findById(1);
//		System.out.println(optional.get().toString());
		
		Optional<Invoice> optional = invoiceRepository.findById(3);
		if(optional.isPresent()) {
			Invoice invoice = optional.get();
			System.out.println(invoice.toString());
			Date dueDate = new Date();
			invoice.setDueDate(dueDate);
			invoice.setBillingAddress("台南東區");
			invoice.setPaymentMethod("信用卡");
			invoice.setSubtotal(1010.0);
			invoice.setTaxAmount(22.2);
			invoice.setTotalAmount(1032.0);
			invoice.setIsPaid("0");
			Invoice newInvoice = invoiceRepository.save(invoice);
			System.out.println(newInvoice.toString());
		}
	}

	
}
