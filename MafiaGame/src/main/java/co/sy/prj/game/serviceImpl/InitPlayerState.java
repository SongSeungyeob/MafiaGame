package co.sy.prj.game.serviceImpl;


import co.sy.prj.comm.Command;
import co.sy.prj.game.service.GameService;

public class InitPlayerState implements Command { 
	
	@Override
	public void execute() {
		GameService gameService = new GameServiceImpl();
		gameService.initPlayerState();
		gameService.deleteSpeciallist();
	}

}
