package co.sy.prj.player.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerVO {
	String id;
	String password;
	String nickname;
	String job;
	int vote;
	int idx;
	char havejob;
	char live;
	
	public void toListPrint(int idx) {
		this.idx = idx;
		System.out.print(idx + ". " + nickname + "\t");
	}
	
	public void toPrint() {
		System.out.println("* " + nickname + " - " + job);
	}
}
