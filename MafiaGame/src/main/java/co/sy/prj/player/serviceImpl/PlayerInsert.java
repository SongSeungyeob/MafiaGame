package co.sy.prj.player.serviceImpl;

import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.player.service.PlayerService;
import co.sy.prj.player.service.PlayerVO;

public class PlayerInsert implements Command {

	@Override
	public void execute() {
		PlayerService playerService = new PlayerServiceImpl();
		PlayerVO vo = new PlayerVO();
		int curPlayer = playerService.getPlayerNum();
		String[] playerID = { null, "aaa","bbb","ccc","ddd","eee","fff",
								"ggg","hhh","iii","jjj", "kkk"};
		
		String[] playerName = { null, "player1","player2","player3","player4","player5",
								"player6","player7","player8","player9","player10"};
		
		String id, password, nickname;
		
		System.out.println("[ Player 등록 ] =.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=");
		System.out.println("| * 게임에 참가 가능한 인원이 최대 10명이므로, player는 10명 이상 생성하실 수 없습니다.  |");
		System.out.println("| * Player등록이 귀찮으시다면, Player 자동 생성 기능을 이용하실 수 있습니다.          |");
		System.out.println("| * 현재 player는 " + curPlayer + "명 등록되어 있습니다.                     |");
		System.out.println("*=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=");
		int select = 0;
		while(true) {
			select = GB.readInt("- Player를 자동으로 생성하길 원하시면 1번을, 직접 생성하길 원하시면 2번을 입력해주세요");
			if(select == 0 || select == 1) break;
			else {
				System.out.println("- 잘못된 입력입니다 ! 다시 입력해 주세요 !");
			}
		}
		
		if(select == 1) {
			while(true) {
				int insertNum = GB.readInt("- 자동으로 생성되길 원하시는 플레이어의 수를 입력해 주세요(1 ~ 10)");
				if(insertNum == 0) {
					System.out.println("- 자동으로 생성 가능한 플레이어의 수는 1 ~ 10 입니다. 다시 입력해 주세요 ! ");
				} else {
					int totalNum = curPlayer + insertNum;
					if(totalNum > 10) {
						System.out.println("- 마피아 게임에 참가 가능한 최대 player수는 10명입니다.");
						System.out.println("- 현재 " + curPlayer + "명의 player가 있으므로 " + insertNum +"명의 player를 추가하실 수 없습니다.");
						System.out.println("- 따라서, 자동적으로 " + (10 - curPlayer) + "명의 player를 추가하겠습니다.");
						insertNum = 10 - curPlayer;
					}
					
					for(int i = 1; i <= insertNum; i++) {
						vo = new PlayerVO();
						vo.setId(playerID[i]);
						vo.setPassword("1234");
						vo.setNickname(playerName[i]);
						
						playerService.insertPlayer(vo);
					}
					System.out.println("\t[ SUCCESS ] : 자동으로 " + insertNum + "명의 player를 생성하였습니다.");
					return;
				}
			}
		}
		else {
			while(true) {
				id = GB.readStr("- ID를 입력하세요");
				if(id.equals("")) {
					System.out.println("- ID는 반드시 입력하셔야 됩니다 ! 다시 입력해 주세요 !");
				} else {
					break;
				}
			}
			
			while(true) {
				password = GB.readStr("- Password를 입력하세요");
				if(password.equals("")) {
					System.out.println("- Password는 반드시 입력하셔야 됩니다 ! 다시 입력해 주세요 !");
				} else {
					break;
				}
			}
			
			while(true) {
				nickname = GB.readStr("- 게임 내에서 사용할 nickname을 입력하세요");
				if(nickname.equals("")) {
					System.out.println("- nickname은 반드시 입력햐셔야 됩니다 ! 다시 입력해 주세요 !");
				} else {
					break;
				}
			}
		}
		vo.setId(id);
		vo.setPassword(password);
		vo.setNickname(nickname);
		
		int n = playerService.insertPlayer(vo);
		if(n != 0) {
			System.out.println("\t [ SUCCESS REGISTER ] : '" + nickname + "'님 게임 참가를 환영합니다.");
		} else {
			System.out.println("- '" + nickname + "' 님을 등록할 수 없습니다 ! ");
		}
	}

}
