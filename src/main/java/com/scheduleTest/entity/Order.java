package com.scheduleTest.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "tax_amount")
    private Double taxAmount;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}

