package com.zombiegame.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zombiegame.springboot.domain.Member;
import com.zombiegame.springboot.repository.MemberRepository;

@Service
public class MemberService {	//인터페이스 생성안했음
	
	@Autowired
	private MemberRepository mRepository;
	
	public Member addMember(Member member) {
		return mRepository.save(member);
	}
	public void deleteMember(Long id) {
		mRepository.deleteById(id);
	}
	public List<Member> getAllMembers() {
		return mRepository.findAll();
	}
	
	public Member getMemberByEmail(String email) {
		return mRepository.findByEmail(email);
	}
	
}
