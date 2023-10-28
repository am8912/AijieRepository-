package com.scheduleTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduleTest.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
