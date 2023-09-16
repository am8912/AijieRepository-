package com.scheduleTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scheduleTest.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

	@Query(value = "select * from member where member_name =:mbName",
            nativeQuery = true)
    List<Member> findMemberNativeSql(@Param("mbName") String memberName);
	
	@Query(value = "from Member where name =?1")
    List<Member> findMemberHql(String memberName);
}
