package com.scheduleTest.service;

import java.util.List;

import com.scheduleTest.entity.Member;

public interface MemberService {
	
	Member getMember(Integer memberId);
	List<Member> getMemberByName(String memberName);
	List<Member> getMemberByHql(String memberName);
	List<Member> findMemberByWords(String name);
}
