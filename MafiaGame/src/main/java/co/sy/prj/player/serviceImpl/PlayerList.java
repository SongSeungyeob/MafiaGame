package co.sy.prj.player.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;

public class PlayerList implements Command {
	
	@Override
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		List<PlayerVO> list = new ArrayList<PlayerVO>();
		
		list = playerService.getPlayerList();
		
		System.out.println("[ Player List ] ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.");
		int Num = 1;
		int Cnt = 0;
		for(PlayerVO vo : list) {
			vo.toListPrint(Num);
			vo.setIdx(Num++);
			playerService.updatePlayer(vo);
			Cnt++;
			if(Cnt % 5 == 0 && Cnt < list.size()) {
				System.out.println();
			}
		}
		System.out.println("\nㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.");
	}

}
