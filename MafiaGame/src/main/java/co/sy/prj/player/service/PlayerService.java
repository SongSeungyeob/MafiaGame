package co.sy.prj.player.service;

import java.util.List;

public interface PlayerService {
	List<PlayerVO> getPlayerList();
	List<PlayerVO> getCitizenList();
	List<PlayerVO> getVoteResult();
	List<PlayerVO> getPlayerTotalList();
	PlayerVO getPlayerSelect(PlayerVO vo);
	int getPlayerNum();
	int getCitizenNum();
	int getMafiaNum();
	int insertPlayer(PlayerVO vo);
	int updatePlayer(PlayerVO vo);
	int updateVote(PlayerVO vo);
	int insertSpeciallist(PlayerVO vo); 	
}
