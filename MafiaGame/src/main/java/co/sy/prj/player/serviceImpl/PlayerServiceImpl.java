package co.sy.prj.player.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.sy.prj.comm.DataSource;
import co.sy.prj.player.service.PlayerMapper;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;

public class PlayerServiceImpl implements PlayerService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private PlayerMapper playerMap = sqlSession.getMapper(PlayerMapper.class);
	
	@Override
	public int insertPlayer(PlayerVO vo) {
		return playerMap.insertPlayer(vo);
	}
	
	public List<PlayerVO> getPlayerList() {
		return playerMap.getPlayerList();
	}

	@Override
	public int insertSpeciallist(PlayerVO vo) {
		return playerMap.insertSpeciallist(vo);
	}

	@Override
	public int getPlayerNum() {
		return playerMap.getPlayerNum();
	}

	@Override
	public List<PlayerVO> getCitizenList() {
		return playerMap.getCitizenList();
	}

	@Override
	public PlayerVO getPlayerSelect(PlayerVO vo) {
		return playerMap.getPlayerSelect(vo);
	}

	@Override
	public int updatePlayer(PlayerVO vo) {
		return playerMap.updatePlayer(vo);
	}

	@Override
	public List<PlayerVO> getVoteResult() {
		return playerMap.getVoteResult();
	}

	@Override
	public int updateVote(PlayerVO vo) {
		return playerMap.updateVote(vo);
	}

	@Override
	public int getCitizenNum() {
		return playerMap.getCitizenNum();
	}

	@Override
	public int getMafiaNum() {
		return playerMap.getMafiaNum();
	}

	@Override
	public List<PlayerVO> getPlayerTotalList() {
		return playerMap.getPlayerTotalList();
	}
	
	
}
