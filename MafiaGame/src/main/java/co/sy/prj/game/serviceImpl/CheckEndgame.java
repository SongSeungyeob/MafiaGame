package co.sy.prj.game.serviceImpl;


import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.serviceImpl.PlayerServiceImpl;

public class CheckEndgame implements Command {

	@Override
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		int mafiaNum = playerService.getMafiaNum();
		int citizenNum = playerService.getCitizenNum();
		

		if(mafiaNum == 0) {
			GB.Winner = "시민";
		} else {
			if(mafiaNum == citizenNum) {
				GB.Winner = "마피아";
			}
		}
	}

}
