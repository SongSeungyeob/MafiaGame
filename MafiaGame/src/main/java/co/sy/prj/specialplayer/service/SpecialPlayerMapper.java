package co.sy.prj.specialplayer.service;

import java.util.List;

public interface SpecialPlayerMapper {
	List<SpecialVO> specialPlayerList();
	List<SpecialVO> getMafiaList();
	SpecialVO getSpecialPlayer(SpecialVO vo);
	int updateSpeciallist(SpecialVO vo);
	int insertSpecialPlayer(SpecialVO vo);
}
