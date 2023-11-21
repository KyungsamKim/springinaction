package com.ssafy.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	
	@Autowired
	private MemberServiceImpl(MemberMapper memberDao) {
		this.memberMapper = memberDao;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return memberMapper.idCheck(userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		memberMapper.joinMember(memberDto);
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) throws Exception {
		return memberMapper.loginMember(map);
	}

	@Override
	public MemberDto getMember(String userId) throws Exception {
		return memberMapper.getMember(userId);
	}

	@Override
	public void modifyMember(Map<String, String> map) throws Exception {
		memberMapper.modifyMember(map);
		return;
	}

	@Override
	public void deleteMember(String deleteId) throws Exception {
		memberMapper.deleteMember(deleteId);
	}

}
