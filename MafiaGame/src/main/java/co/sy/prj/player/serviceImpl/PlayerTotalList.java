package co.sy.prj.player.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;

public class PlayerTotalList implements Command {

	@Override
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		List<PlayerVO> list = new ArrayList<>();
		list = playerService.getPlayerTotalList();
		for(PlayerVO vo : list) {
			vo.toPrint();
		}
	}

}
