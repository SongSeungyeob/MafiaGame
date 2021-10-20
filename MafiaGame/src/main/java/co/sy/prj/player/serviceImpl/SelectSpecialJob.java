package co.sy.prj.player.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;
import co.sy.prj.specialplayer.service.SpecialPlayerService;
import co.sy.prj.specialplayer.service.SpecialVO;
import co.sy.prj.specialplayer.serviceImpl.SpecialPlayerServiceImpl;

public class SelectSpecialJob implements Command {

	@Override
	public void execute() {
		String job = "";
		int selectCnt = 0;
		switch (GB.TURN) {
		case 1:
			job = "마피아";
			selectCnt = GB.MAFIA[GB.PLAYERCNT];
			break;
		case 2:
			job = "의사";
			selectCnt = 1;
			break;
		case 3:
			job = "경찰";
			selectCnt = 1;
			break;
		}

		PlayerService playerService = new PlayerServiceImpl();

		System.out.println("† 게임 시작 전, 특수 직업 '" + job + "'을(를) 선정하겠습니다. †");
		System.out.println("† '" + job + "'은(는) " + selectCnt + "명을 뽑겠습니다. †");

		boolean[] Visit = new boolean[playerService.getCitizenNum() + 1];
		for (int i = 0; i < selectCnt; i++) {
			while (true) {
				int select = GB.readInt("- '" + job + "' 역할을 수행할 사람의 번호를 입력하세요");
				if (select == 0 || select > playerService.getCitizenNum()) {
					System.out.println("- [ ERROR ] : 잘못된 입력입니다 ! 다시 입력해 주세요 !");
				} else {
					if (Visit[select] == true) {
						System.out.println("[ ERROR ] : 이미 선택된 플레이어 입니다. 다른 플레이어를 선택해주세요 !");
					} else {
						Visit[select] = true;
						PlayerVO vo = new PlayerVO();
						vo.setIdx(select);
						vo = playerService.getPlayerSelect(vo);

						vo.setHavejob('1');
						vo.setJob(job);
						int n = playerService.updatePlayer(vo);
						if (n != 0) {
							System.out
									.println("\t[ SUCCESS ] : '" + vo.getNickname() + "'님을 '" + job + "'로 선정 하였습니다.\n");
						} else {
							System.out.println("- [ ERROR ] : UPDATE 부분에서 ERROR 발생 !!!! ");
						}
						playerService.insertSpeciallist(vo);
						vo.setIdx(-1);
						playerService.updatePlayer(vo);
						break;
					}
				}
			}
		}
		
		if (job.equals("경찰")) {
			SpecialPlayerService sps = new SpecialPlayerServiceImpl();
			List<SpecialVO> list = new ArrayList<>();
			list = sps.specialPlayerList();
			System.out.println("[ 특수 직업 결과 ]===============================");
			for (SpecialVO svo : list) {
				svo.toListPrint();
			}
			System.out.println("=============================================\n");
		}
	}
}
