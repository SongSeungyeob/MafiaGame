package co.sy.prj.specialplayer.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialVO {
	String nickname;
	String job;
	char live;
	String info;
	int idx;
	
	public void toListPrint() {
		System.out.println("* " + job + " - " + nickname);
	}
}
