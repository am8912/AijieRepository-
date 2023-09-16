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
//		memberRepository.findById(memberId).orElse(null);
//		List<Member> result = memberRepository.findMemberNativeSql("addy");
		return memberRepository.findById(memberId).orElse(null);
	}

}
