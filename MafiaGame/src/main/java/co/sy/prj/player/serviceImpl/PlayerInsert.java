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
		String id,password,nickname;
		System.out.println("[ Player 등록 ] = = = = = = = = = = = = = = = =");
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
