package co.sy.prj.member.service;

public interface MemberService {
	MemberVO memberLogin(MemberVO vo);	// Check Login
	String encKey();					// 암호화 키를 가져오는 Method.
}
