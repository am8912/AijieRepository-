package com.scheduleTest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scheduleTest.entity.Invoice;
import com.scheduleTest.entity.Member;
import com.scheduleTest.repository.MemberRepository;
import com.scheduleTest.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	// 查詢單筆
	@Override
	public Member findById(Integer id) {
		Optional<Member> optional = memberRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	// 查詢所有
	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	// 新增
	@Override
	public Member add(Member member) {
		return memberRepository.save(member);
	}

	// 刪除
	@Override
	public boolean deleteById(Integer id) {
		Optional<Member> optional = memberRepository.findById(id);
		if (optional.isPresent()) {
			memberRepository.deleteById(id);
			return true;
		}
		return false;
	}

	// 修改
	@Override
	public Member update(Integer id, Member newMember) {
		Optional<Member> optional = memberRepository.findById(id);
		if (optional.isPresent()) {
			Member member = optional.get();
			member.setFirstName(newMember.getFirstName());
			member.setLastName(newMember.getLastName());
			member.setEmail(newMember.getEmail());
			member.setPhone(newMember.getPhone());
			member.setBirthDate(newMember.getBirthDate());
			member.setGender(newMember.getGender());
			member.setRegistrationDate(newMember.getRegistrationDate());
			member.setIsActive(newMember.getIsActive());
			member.setMembershipLevel(newMember.getMembershipLevel());
			return memberRepository.save(member);
		}
		return null;
	}

//	@Override
//	public Member getMember(Integer memberId){		
//		return memberRepository.findById(memberId).orElse(null);
//	}
//	@Override
//	public List<Member> getMemberByName(String memberName) {
//	    List<Member> result = memberRepository.findMemberNativeSql(memberName);
//	    return result;
//	}
//	@Override
//	public List<Member> getMemberByHql(String memberName) {
//		List<Member> result = memberRepository.findMemberHql(memberName);
//		return result;
//	}
//	@Override
//	public List<Member> findMemberByWords(String name) {
//		List<Member> result = memberRepository.findMemberByWords(name);
//		return result;
//	}
//	
//	@Override
//	public Member create(Member member) {
//		return memberRepository.save(member);
//	}
//		
//	@Override
//	public ResponseEntity<String> updateById(Integer memberId,String name,String mail,String phone){
//		Optional<Member> optional = memberRepository.findById(memberId);
//		if(optional.isPresent()) {
//			Member member = optional.get();
//			optional.get().setEmail(mail);
//			optional.get().setFirstName(name);
//			optional.get().setPhone(phone);
//			memberRepository.save(member);
//			return new ResponseEntity<>("修改OK",HttpStatus.OK);
//		}
//		return new ResponseEntity<>("沒有這筆資料",HttpStatus.BAD_REQUEST);
//	}
//	
//	@Override
//	public ResponseEntity<String> deleteMemberById(Integer memberId) {
//		Optional<Member> optioanl = memberRepository.findById(memberId);
//		if(optioanl.isEmpty()) {
//			return new ResponseEntity<>("沒有這筆資料",HttpStatus.OK);
//		}
//		memberRepository.deleteById(memberId);
//		return new ResponseEntity<>("刪除成功",HttpStatus.OK);
//	}

}
