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

public class PlayerVote implements Command {

	@Override
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		List<PlayerVO> list = new ArrayList<>();
		list = playerService.getPlayerList();
		
		System.out.println("[ 투표를 진행하겠습니다. ] ");
		for(int i = 0 ; i < list.size(); i++) {
			while (true) {
				int select = GB.readInt("'" + list.get(i).getNickname() + "'님, 추방시킬 사람의 번호를 입력해 주세요." + "(기권표는 '0'을 입력해주세요)");
				if(select > list.size()) {
					System.out.println("[ ERROR ] : 잘못된 입력 번호입니다. 다시 입력해 주세요 !");
				} else if(select != 0){
					PlayerVO vo = new PlayerVO();
					vo.setIdx(select);
					vo = playerService.getPlayerSelect(vo);
					playerService.updateVote(vo);
					break;
				} else {
					break;
				}
			}
		}
		System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.\n");
		list = playerService.getVoteResult();
		int maxVote = list.get(0).getVote();
		System.out.println("[ 투표 결과 ] =.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.");
		if(maxVote == 0) {
			System.out.println("| * 아무도 추방당하지 않았습니다. 게임을 계속해서 진행하겠습니다.");
		} else {
			if(list.get(1).getVote() == maxVote) {
				System.out.println("| * 최고 득표자가 2명 이상이 나왔으므로, 아무도 추방당하지 않았습니다. 게임을 계속해서 진행하겠습니다.");
			} else {
				System.out.println("| * '" + list.get(0).getNickname() + "'님께서 " + maxVote + "표로 추방당하였습니다.");
				PlayerVO vo = list.get(0);
				vo.setLive('0');
				playerService.updatePlayer(vo);
				
				if(vo.getHavejob() == '1') {
					SpecialPlayerService sps = new SpecialPlayerServiceImpl();
					SpecialVO svo = new SpecialVO();
					svo.setNickname(vo.getNickname());
					svo = sps.getSpecialPlayer(svo);
					svo.setLive('0');
					sps.updateSpeciallist(svo);
				}
			}
		}
		System.out.println("=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.");
		
		System.out.println();
		list = playerService.getPlayerList();
		for(PlayerVO pvo : list) {
			pvo.setVote(0);
			pvo.setIdx(-1);
			playerService.updatePlayer(pvo);
		}
	}

}
