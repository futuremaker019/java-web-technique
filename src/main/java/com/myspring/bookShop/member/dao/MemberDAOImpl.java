package com.myspring.bookShop.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.bookShop.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public MemberVO login(Map loginMap) throws DataAccessException {
		return sqlSession.selectOne("mapper.member.login", loginMap);
	}
	
	public void insertMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.insert("mapper.member.insertNewMember", memberVO);
	}
	
	public String selectOverlappedID(String id) throws DataAccessException {
		return sqlSession.selectOne("mapper.member.selectOverlappedID", id);
	}
}
