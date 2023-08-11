package kr.co.coupang.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.coupang.member.domain.Member;
import kr.co.coupang.member.service.MemberService;
import kr.co.coupang.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	
	// bean을 만들어 놓아서 사용 가능(root-context.xml)
	@Autowired
	private SqlSession sqlSession; 
	
	@Autowired
	private MemberStore mStore;
	
	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMember(sqlSession, member);
		return result;
	}

	@Override
	public Member memberLoginCheck(Member member) {
		Member mOne = mStore.selectMemberLogin(sqlSession, member);
		return mOne;
	}

	@Override
	public Member showOneById(String memberId) {
		Member mOne = mStore.selectOneById(sqlSession, memberId);
		return mOne;
	}

	@Override
	public int removeMember(String memberId) {
		int result = mStore.deleteMember(sqlSession, memberId);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(sqlSession, member);
		return result;
	}
	
}
