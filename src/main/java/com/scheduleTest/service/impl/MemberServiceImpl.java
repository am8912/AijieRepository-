package com.scheduleTest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@Override
	public List<Member> findMemberByWords(String name) {
		List<Member> result = memberRepository.findMemberByWords(name);
		return result;
	}
	
	@Override
	public Member create(Member member) {
		return memberRepository.save(member);
	}
		
	@Override
	public ResponseEntity<String> updateById(Integer memberId,String name,String mail,String phone){
		Optional<Member> optional = memberRepository.findById(memberId);
		if(optional.isPresent()) {
			Member member = optional.get();
			optional.get().setMail(mail);
			optional.get().setName(name);
			optional.get().setPhone(phone);
			memberRepository.save(member);
			return new ResponseEntity<>("修改OK",HttpStatus.OK);
		}
		return new ResponseEntity<>("沒有這筆資料",HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<String> deleteMemberById(Integer memberId) {
		Optional<Member> optioanl = memberRepository.findById(memberId);
		if(optioanl.isEmpty()) {
			return new ResponseEntity<>("沒有這筆資料",HttpStatus.OK);
		}
		memberRepository.deleteById(memberId);
		return new ResponseEntity<>("刪除成功",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}

















