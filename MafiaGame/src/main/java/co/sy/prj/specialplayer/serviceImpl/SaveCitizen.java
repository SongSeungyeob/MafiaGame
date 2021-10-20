package co.sy.prj.specialplayer.serviceImpl;


import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;
import co.sy.prj.player.serviceImpl.PlayerServiceImpl;
import co.sy.prj.specialplayer.service.SpecialPlayerService;
import co.sy.prj.specialplayer.service.SpecialVO;

public class SaveCitizen implements Command {

	@Override
	public void execute() {
		SpecialPlayerService sps = new SpecialPlayerServiceImpl();
		PlayerService playerService = new PlayerServiceImpl();
		SpecialVO vo = new SpecialVO();
		int	num = playerService.getPlayerNum();
		
		vo.setJob("의사");
		vo = sps.getSpecialPlayer(vo);
		
		if (vo != null) {
			while (true) {
				int select = GB.readInt("* 의사는 오늘 밤, 살릴 사람의 번호를 입력해 주세요");
				if (select == 0 || select > num) {
					System.out.println("[ ERROR ] : 잘못된 입력입니다 ! 다시 입력해 주세요 !");
				} else {
					PlayerVO pvo = new PlayerVO();
					pvo.setIdx(select);
					pvo = playerService.getPlayerSelect(pvo);
					vo.setInfo(pvo.getNickname());
					sps.updateSpeciallist(vo);
					break;
				}
			}
		} else {
			System.out.println("* 의사는 이미 사망하였으므로, 살릴 사람을 선택하지 않고 넘어가겠습니다.");
		}
		System.out.println();
		
		vo = new SpecialVO();
		vo.setJob("경찰");
		vo = sps.getSpecialPlayer(vo);
		if (vo != null) {
			while (true) {
				int select = GB.readInt("* 경찰은 마피아 여부를 알아내고 싶은 사람의 번호를 입력해 주세요");
				if (select == 0 || select > num) {
					System.out.println("[ ERROR ] : 잘못된 입력입니다 ! 다시 입력해 주세요 !");
				} else {
					PlayerVO pvo = new PlayerVO();
					pvo.setIdx(select);
					pvo = playerService.getPlayerSelect(pvo);
					vo.setInfo(pvo.getNickname());
					sps.updateSpeciallist(vo);
					break;
				}
			}
		} else {
			System.out.println("* 경찰은 이미 사망하였으므로, 경찰은 선택하지 않고 넘어가겠습니다.");
		}
	}
}

/*
 * SELECT * FROM player;
SELECT * FROM speciallist;
commit;

UPDATE player
SET job = 'citizen', havejob = '0', idx = -1, vote = 0;

DELETE FROM speciallist;*/
