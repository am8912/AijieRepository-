package com.scheduleTest.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name = "invoices")
public class Invoice {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "tax_amount")
    private Double taxAmount;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "is_paid")
    private String isPaid;

}

