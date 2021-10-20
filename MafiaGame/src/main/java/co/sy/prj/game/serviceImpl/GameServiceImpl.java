package co.sy.prj.game.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import co.sy.prj.comm.DataSource;
import co.sy.prj.game.service.GameMapper;
import co.sy.prj.game.service.GameService;

public class GameServiceImpl implements GameService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private GameMapper gameMap = sqlSession.getMapper(GameMapper.class);
	
	@Override
	public int getPlayerNum() {
		return gameMap.getPlayerNum();
	}

	@Override
	public int initPlayerState() {
		return gameMap.initPlayerState();
	}

	@Override
	public int deleteSpeciallist() {
		return gameMap.deleteSpeciallist();
	}

}
