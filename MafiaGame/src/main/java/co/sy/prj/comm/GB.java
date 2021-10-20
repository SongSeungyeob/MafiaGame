package co.sy.prj.comm;

import java.util.Scanner;


public class GB {
	public static Scanner sc = new Scanner(System.in);
	public static int PLAYERCNT;
	public static int TURN;
	public static int[] MAFIA = { 0, 0, 0, 0, 0, 1, 2, 2, 3, 3, 4, 4, 5 }; 
	public static String Winner = null;
	
	public static int readInt(String msg) {
		System.out.print(msg + " : ");
		int input = sc.nextInt(); sc.nextLine();
		return input;
	}
	
	public static String readStr(String msg) {
		System.out.print(msg + " : ");
		String input = sc.nextLine();
		return input;
	}

	//†
	public static void gameRule() {
		System.out.println("[ GAME RULE ]ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.*");
		System.out.println("| † 최소 5명 이상의 인원이 모이면 게임을 시작하게 됩니다. †");
		System.out.println("| † 마피아 게임은 시민을 제거하려는 마피아와 마피아를 제거하려는 시민의 대결입니다. †");
		System.out.println("| † 게임이 시작되면, player인원 대비, 일정 수의 마피아가 선택되어집니다. †");
		System.out.println("| † 마피아는 마피아인걸 들키지 않은 채로 시민을 모두 죽여야 합니다. †");
		System.out.println("| † 매일 밤, 마피아는 시민들 몰래 한명을 죽일 수 있습니다. †");
		System.out.println("| † 시민 중, 2명은 특수 직업을 부여받게 됩니다. †");
		System.out.println("| † 특수 직업은 '의사'와 '경찰'이 있습니다. †");
		System.out.println("| † 의사는 매일 밤 한 명을 살릴 수 있습니다. †");
		System.out.println("| † 경찰은 매일 밤 한 명을 지목해서 마피아 여부를 알아낼 수 있습니다. †");
		System.out.println("| † 시민은 의사와 경찰의 조사 결과를 바탕으로 마피아를 모두 잡으면 승리하게 됩니다. †");
		System.out.println("| † 매일 아침, 전날 밤에 있었던 일에 대한 힌트가 제공되어지며, 이 힌트를 기반으로 투표를 하게 됩니다. †");
		System.out.println("| † 단, 의사가 사망하게 될 경우 힌트는 \"의사가 시민을 살리지 못했다\"라는 형태로 제공됩니다. †");
		System.out.println("| † 또한, 경찰이 사망하게 될 경우 힌트는 \"경찰이 마피아를 찾지 못했다\"라는 형태로 제공됩니다. †");
		System.out.println("| † 투표를 통해서는 한 사람이 탈락할 수도 있지만, 최고 득표자가 2명 이상이거나 모두 기권을하면 누구도 탈락하지 않을 수도 있습니다. †");
		System.out.println("| † 당신의 뛰어난 추리로 마피아를 잡아주세요 ! †");
		System.out.println("*ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.ㅡ.*\n");
	}
}
