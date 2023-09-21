package com.scheduleTest.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.scheduleTest.entity.Member;

public interface MemberService {
	
	Member getMember(Integer memberId);
	List<Member> getMemberByName(String memberName);
	List<Member> getMemberByHql(String memberName);
	List<Member> findMemberByWords(String name);
	Member create(Member member);
	ResponseEntity<String> updateById(Integer memberId,String name,String mail,String phone);
	ResponseEntity<String> deleteMemberById(Integer memberId);
}
