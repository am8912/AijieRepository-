package com.scheduleTest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.scheduleTest.entity.Invoice;
import com.scheduleTest.entity.Schedule;
import com.scheduleTest.repository.ScheduleRepository;
import com.scheduleTest.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	// 查詢單筆
	@Override
	public Schedule findById(Integer id) {
		Optional<Schedule> optional = scheduleRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	// 查詢所有
	@Override
	public List<Schedule> findAll(){
		return scheduleRepository.findAll();
	}
	
	// 新增
	@Override
	public Schedule add(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	// 刪除
	@Override
	public boolean deleteById(Integer id) {
		Optional<Schedule> optional = scheduleRepository.findById(id);
		if(optional.isPresent()) {
			scheduleRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	// 修改
	@Override
	public Schedule update(Schedule newSchedule) {
		Optional<Schedule> optional = scheduleRepository.findById(newSchedule.getScheduleId());
		if(optional.isPresent()) {
			Schedule schedule = optional.get();
			schedule.setJobName(newSchedule.getJobName());
			schedule.setJobClass(newSchedule.getJobClass());
			schedule.setDescription(newSchedule.getDescription());
			schedule.setIpPort(newSchedule.getIpPort());
			schedule.setHostName(newSchedule.getHostName());
			schedule.setStatus(newSchedule.getStatus());
			schedule.setCreateDate(newSchedule.getCreateDate());
			schedule.setModifyDate(newSchedule.getModifyDate());
			schedule.setCustomField1(newSchedule.getCustomField1());
			schedule.setCustomField2(newSchedule.getCustomField2());
			return schedule;
		}
		return	null;	
	}

}
