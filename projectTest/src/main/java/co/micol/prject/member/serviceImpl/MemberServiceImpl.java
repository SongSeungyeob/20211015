package co.micol.prject.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prject.comm.DataSource;
import co.micol.prject.member.service.MemberMapper;
import co.micol.prject.member.service.MemberSerVice;
import co.micol.prject.member.service.MemberVO;

public class MemberServiceImpl implements MemberSerVice {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}
}
