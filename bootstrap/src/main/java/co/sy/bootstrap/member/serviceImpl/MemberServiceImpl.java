package co.sy.bootstrap.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.sy.bootstrap.member.service.MemberMapper;
import co.sy.bootstrap.member.service.MemberService;
import co.sy.bootstrap.member.service.MemberVO;
import co.sy.bootstrap.comm.DataSource;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getDataSource().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);

	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberUpdate(vo);
	}

	@Override
	public boolean memberIdCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberIdCheck(vo);
	}

	@Override
	public int memberAuthorUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return map.memberAuthorUpdate(vo);
	}


}
