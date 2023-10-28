package com.scheduleTest.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "schedules")
public class Schedule {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_class")
    private String jobClass;

    @Column(name = "description")
    private String description;

    @Column(name = "ip_port")
    private String ipPort;

    @Column(name = "host_name")
    private String hostName;

    @Column(name = "status")
    private boolean status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(name = "custom_field1")
    private String customField1;

    @Column(name = "custom_field2")
    private String customField2;
  
}

