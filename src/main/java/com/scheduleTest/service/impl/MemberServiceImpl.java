package com.scheduleTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scheduleTest.entity.Member;
import com.scheduleTest.repository.MemberRepository;
import com.scheduleTest.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public Member getMember(Integer memberId){		
		return memberRepository.findById(memberId).orElse(null);
	}
	@Override
	public List<Member> getMemberByName(String memberName) {
	    List<Member> result = memberRepository.findMemberNativeSql(memberName);
	    return result;
	}
	@Override
	public List<Member> getMemberByHql(String memberName) {
		List<Member> result = memberRepository.findMemberHql(memberName);
		return result;
	}
	
	
	
	
	
	
	
	
	
}

















