package com.scheduleTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduleTest.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
