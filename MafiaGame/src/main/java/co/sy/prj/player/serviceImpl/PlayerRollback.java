package co.sy.prj.player.serviceImpl;

import co.sy.prj.comm.Command;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;

public class PlayerRollback implements Command {

	@Override
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		
		PlayerVO vo = new PlayerVO();
		vo.setJob("의사");
		vo = playerService.getPlayerSelect(vo);
		vo.setJob("시민");
		playerService.updatePlayer(vo);
		
		vo = new PlayerVO();
		vo.setJob("경찰");
		vo = playerService.getPlayerSelect(vo);
		vo.setJob("시민");
		playerService.updatePlayer(vo);

	}

}
