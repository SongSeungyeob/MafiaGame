package co.sy.prj.specialplayer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;
import co.sy.prj.player.serviceImpl.PlayerServiceImpl;
import co.sy.prj.specialplayer.service.SpecialPlayerService;
import co.sy.prj.specialplayer.service.SpecialVO;

public class KillCitizen implements Command {
	@Override
	
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		SpecialPlayerService sps = new SpecialPlayerServiceImpl();
		List<SpecialVO> mlist = new ArrayList<>();
		mlist = sps.getMafiaList();
		int num = playerService.getPlayerNum();
		
		System.out.println("† 마피아들은 누굴 죽일지 상의해 주세요... †");
		
		while (true) {
			int select = GB.readInt("- 마피아들은 죽일 시민의 번호를 입력해 주세요");
			if(select == 0 || select > num) {
				System.out.println("[ ERROR ] : 잘못된 번호 입력입니다. 다시 입력해주세요 !");
			} else {
				PlayerVO pvo = new PlayerVO();
				pvo.setIdx(select);
				pvo = playerService.getPlayerSelect(pvo);
				for(SpecialVO vo : mlist) {
					vo.setInfo(pvo.getNickname());
					sps.updateSpeciallist(vo);
				}
				break;
			}
		}
		System.out.println();
	}
}
