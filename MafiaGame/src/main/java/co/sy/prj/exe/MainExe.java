package co.sy.prj.exe;

import java.util.HashMap;
import java.util.Map;

import co.sy.prj.comm.Command;
import co.sy.prj.comm.GB;
import co.sy.prj.game.serviceImpl.CheckEndgame;
import co.sy.prj.game.serviceImpl.GetPlayerNum;
import co.sy.prj.game.serviceImpl.InitPlayerState;
import co.sy.prj.player.serviceImpl.PlayerCitizenList;
import co.sy.prj.player.serviceImpl.PlayerInsert;
import co.sy.prj.player.serviceImpl.PlayerList;
import co.sy.prj.player.serviceImpl.PlayerRollback;
import co.sy.prj.player.serviceImpl.PlayerTotalList;
import co.sy.prj.player.serviceImpl.PlayerVote;
import co.sy.prj.player.serviceImpl.SelectSpecialJob;
import co.sy.prj.specialplayer.serviceImpl.KillCitizen;
import co.sy.prj.specialplayer.serviceImpl.NightResult;
import co.sy.prj.specialplayer.serviceImpl.SaveCitizen;

public class MainExe {

	private Map<String, Command> map = new HashMap<String, Command>();

	public MainExe() {
		map.put("getPlayerNum", new GetPlayerNum());
		map.put("initPlayerState", new InitPlayerState());
		map.put("addPlayer", new PlayerInsert());
		map.put("playerlist", new PlayerList());
		map.put("citizenlist", new PlayerCitizenList());
		map.put("updatePlayer", new SelectSpecialJob());
		map.put("doVote", new PlayerVote());
		map.put("killCitizen", new KillCitizen());
		map.put("nightResult", new NightResult());
		map.put("rollbackDoctorPolice", new PlayerRollback());
		map.put("saveCitizen", new SaveCitizen());
		map.put("checkEndgame", new CheckEndgame());
		map.put("resultList", new PlayerTotalList());
	}

	private void menu() {
		System.out.println("*ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ*");
		System.out.println("†            MAFIA 게임에 오신걸 환영합니다.            †");
		System.out.println("*ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ*");
		secondMenu();
	}

	private void secondMenu() {
		while(true) {
			System.out.println("\n\t     [ MENU SELECT ]ㅡ.ㅡ*");
			System.out.println("\t     | 0. Game 규칙      |");
			System.out.println("\t     | 1. Game 시작      |");
			System.out.println("\t     | 2. Player 추가    |");
			System.out.println("\t     | 3. Game 종료      |");
			System.out.println("\t     *ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ*");
			int select = GB.readInt("- 메뉴를 선택하세요");
			System.out.println();
			if(select == 0) {
				GB.gameRule();
			}
			else if(select == 1) {
				execute("getPlayerNum");
				if(GB.PLAYERCNT >= 5) {
					game();
				} 
			} else if(select == 2) {
				execute("addPlayer");
			} else if (select == 3){
				System.out.println("[ MAFIA 게임을 이용해 주셔서 감사합니다. 게임을 종료하겠습니다. ]");
				break;
			} else {
				System.out.println("[ ERROR INPUT ] : 잘못된 입력입니다 ! 다시 입력해 주세요 !");
			}
		}
	}

	private void game() {
		setting();
		int day = 1;
		
		while(true) {
			Morning(day);
			if(checkEnd()) break;
			Night(day++);
		}
	}
	
	private void setting() {
		GB.TURN = 1;
		execute("playerlist");
		execute("updatePlayer");
		
		GB.TURN = 2;
		execute("citizenlist");
		execute("updatePlayer");
		
		GB.TURN = 3;
		execute("citizenlist");
		execute("updatePlayer");
		execute("rollbackDoctorPolice");
	}
	
	private boolean checkEnd() {
		execute("checkEndgame");
		if(GB.Winner != null) {
			System.out.println("[ 게임이 종료되었습니다. ]============================*");
			System.out.println("* " + GB.Winner + "의 승리로 게임이 종료되었습니다. *       ");
			execute("resultList");
			System.out.println("================================================*");
			execute("initPlayerState");
			return true;
		}
		return false;
	}
	
	private void Night(int d) {
		System.out.println("†ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ†");
		System.out.println("|  [ " + d + " ]일  밤    |");
		System.out.println("†ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ†");
		System.out.println("† 게임시작 '" + d + "'일 차, 밤이 되었습니다... †'");
		System.out.println("† 모두 잠에 든 사이, 마피아와 의사, 경찰의 활동이 시작됩니다... †");
		execute("citizenlist");
		execute("killCitizen");
		execute("playerlist");
		execute("saveCitizen");
	}
	
	private void Morning(int d) {
		System.out.println("\n†ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ†");
		System.out.println("|  [ " + d + " ]일  낮    |");
		System.out.println("†ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ†");
		System.out.println("† '" + d + "'일 차, 아침이 밝았습니다. †");
		
		if(d == 1) {
			System.out.println("† 1일차 이므로, 제공되는 힌트가 없습니다. 따라서, 바로 투표를 진행하도록 하겠습니다. †");
		} else {
			System.out.println("† " + (d - 1) + "일차 밤에 있었던 사건들을 기반으로, 힌트를 제공하겠습니다. † ");
			System.out.println("[ HINT ] =.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=");
			execute("nightResult");
			System.out.println("†=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=\n");
			
			if(checkEnd()) {
				return;
			}
		}
		execute("playerlist");
		execute("doVote");	
	}
	
	private void execute(String str) {
		Command cmd = map.get(str);
		cmd.execute();
	}
	
	public void run() {
		menu();
	}
}
