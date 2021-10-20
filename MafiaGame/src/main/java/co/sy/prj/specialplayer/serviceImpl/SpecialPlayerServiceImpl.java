package co.sy.prj.specialplayer.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.sy.prj.comm.DataSource;
import co.sy.prj.specialplayer.service.SpecialPlayerMapper;
import co.sy.prj.specialplayer.service.SpecialPlayerService;
import co.sy.prj.specialplayer.service.SpecialVO;

public class SpecialPlayerServiceImpl implements SpecialPlayerService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private SpecialPlayerMapper SplayerMap = sqlSession.getMapper(SpecialPlayerMapper.class);
	
	@Override
	public int insertSpecialPlayer(SpecialVO vo) {
		return SplayerMap.insertSpecialPlayer(vo);
	}

	@Override
	public List<SpecialVO> specialPlayerList() {
		return SplayerMap.specialPlayerList();
	}

	@Override
	public List<SpecialVO> getMafiaList() {
		return SplayerMap.getMafiaList();
	}

	@Override
	public int updateSpeciallist(SpecialVO vo) {
		return SplayerMap.updateSpeciallist(vo);
	}

	@Override
	public SpecialVO getSpecialPlayer(SpecialVO vo) {
		return SplayerMap.getSpecialPlayer(vo);
	}

}
