package co.sy.prj.game.serviceImpl;

import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.game.service.GameService;

public class GetPlayerNum implements Command {
	private GameService gameService;
	
	@Override
	public void execute() {
		gameService = new GameServiceImpl();
		int playerNum = gameService.getPlayerNum();
		if(playerNum < 5) {
			System.out.println("[ ERROR ] : 마피아 게임 진행을 위해 필요한 최소 인원은 5명 입니다 ! 현재 " + playerNum + "명만 존재합니다.");
			return;
		} else { 	
			GB.PLAYERCNT = playerNum;
		}
	}
	
}
