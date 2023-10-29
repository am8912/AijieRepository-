package com.scheduleTest.service;

import java.util.List;

import com.scheduleTest.entity.Schedule;

public interface ScheduleService {

	Schedule findById(Integer id);
	
	List<Schedule> findAll();
	
	Schedule add(Schedule schedule);
	
	boolean deleteById(Integer id);
	
	Schedule update(Schedule newSchedule);
}
