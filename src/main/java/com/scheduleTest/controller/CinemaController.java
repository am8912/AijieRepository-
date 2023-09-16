package com.scheduleTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.scheduleTest.entity.Member;
import com.scheduleTest.service.MemberService;

@RestController
public class CinemaController {
	
	@Autowired
	MemberService memberService;
	
	// http://127.0.0.1:8082/getMember/{memberId}
	@RequestMapping(path = "/getMember/{memberId}", method = RequestMethod.GET)
	public ResponseEntity<String> getMember(@PathVariable String memberId) throws Exception {
        
		// Step1. 檢查URL的memberId是否為數字
		Integer id;
        try {
         	id= Integer.parseInt(memberId);
        }catch (Exception e) {
        	return new ResponseEntity<>("ID輸入不正確",HttpStatus.OK);
        }
        
        // Step2. 查詢是否有該使用者
		Member member = memberService.getMember(id);
		if(member!= null) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			return new ResponseEntity<>(gson.toJson(member), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("查無該使用者ID: " + id ,HttpStatus.OK);
		}
	}
}
