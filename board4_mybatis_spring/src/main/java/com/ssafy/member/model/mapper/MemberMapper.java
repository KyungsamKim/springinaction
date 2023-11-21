package com.ssafy.member.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	MemberDto getMember(String userId) throws SQLException;
	void modifyMember(Map<String, String> map) throws SQLException;
	void deleteMember(String deleteId)throws SQLException;
}
