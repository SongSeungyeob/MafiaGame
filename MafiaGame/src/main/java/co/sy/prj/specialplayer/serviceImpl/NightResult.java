package co.sy.prj.specialplayer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;
import co.sy.prj.player.serviceImpl.PlayerServiceImpl;
import co.sy.prj.specialplayer.service.SpecialPlayerService;
import co.sy.prj.specialplayer.service.SpecialVO;

public class NightResult implements Command {

	@Override
	public void execute() {
		SpecialPlayerService sps = new SpecialPlayerServiceImpl();
		PlayerService playerService = new PlayerServiceImpl();
		List<SpecialVO> mafia = new ArrayList<>();
		SpecialVO vo = new SpecialVO();
		String mafiaKill = null;
		String doctorSave = null;
		String policeKnow = null;

		mafia = sps.getMafiaList();
		mafiaKill = mafia.get(0).getInfo();

		doctorSave = null;
		vo.setJob("의사");
		vo = sps.getSpecialPlayer(vo);
		if (vo != null) {
			doctorSave = vo.getInfo();
		}

		policeKnow = null;
		vo = new SpecialVO();
		vo.setJob("경찰");
		vo = sps.getSpecialPlayer(vo);
		if (vo != null) {
			policeKnow = vo.getInfo();
		}

		if (policeKnow == null) {
			System.out.println("| * 어젯 밤, 경찰이 마피아를 찾아내지 못하였습니다. *");
		} else {
			PlayerVO pvo = new PlayerVO();
			pvo.setNickname(policeKnow);
			pvo = playerService.getPlayerSelect(pvo);
			if (pvo.getJob().equals("시민")) {
				System.out.println("| * 어젯 밤, 경찰이 마피아를 찾아내지 못하였습니다. *");
			} else {
				System.out.println("| * 어젯 밤, 경찰이 '" + pvo.getNickname() + "'님이 마피아 라는 것을 알아냈습니다. *");
			}
		}

		if (mafiaKill.equals(doctorSave)) {
			System.out.println("| * 어젯 밤, 의사가 마피아로부터 살해되는 사람을 살렸으므로, 아무도 살해당하지 않았습니다. *");
		} else {
			System.out.println("| * 어젯 밤, 의사가 마피아로부터 살해되는 사람을 살리지 못하였습니다 ㅠㅠ.. *");
			System.out.println("| * 따라서, 어젯 밤 마피아로부터 선량한 시민 '" + mafiaKill + "'님이 살해당하셨습니다. *");
			PlayerVO pvo = new PlayerVO();
			pvo.setNickname(mafiaKill);
			pvo = playerService.getPlayerSelect(pvo);
			pvo.setLive('0');
			playerService.updatePlayer(pvo);
		}
	}
}
