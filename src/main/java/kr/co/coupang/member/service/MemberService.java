package kr.co.coupang.member.service;

import kr.co.coupang.member.domain.Member;

public interface MemberService {
	/**
	 * 멤버 등록 Service
	 * @param member
	 * @return int
	 */
	public int registerMember(Member member);

	/**
	 * 멤버 로그인 Service 
	 * @param 아아디, 비밀번호
	 * @return member객체
	 */
	public Member memberLoginCheck(Member member);
	
	/**
	 * 회원 상세 조회
	 * @param memberId
	 * @return member객체
	 */
	public Member showOneById(String memberId);

	/**
	 * 멤버 삭제 Service
	 * @param memberId
	 * @return int
	 */
	public int removeMember(String memberId);

	/**
	 * 회원 정보 수정
	 * @param memberId
	 * @return int
	 */
	public int modifyMember(Member member);
	
}
