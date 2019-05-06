package Round1C;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = Integer.parseInt(scan.nextLine());
		for(int t = 1; t <= cases; t++) {
			int adv = Integer.parseInt(scan.nextLine());
			String programs[] = new String[adv];
			for(int a = 0; a < adv; a++){
				programs[a] = scan.nextLine();
			}
			StringBuilder stb = new StringBuilder();
			boolean winable = true;
			int gamesPlayed = 0;

			while(winable && gamesPlayed < 500 && programs.length > 0) {
				String next = nextMove(programs, gamesPlayed);
				winable = !next.equals("");
				if(!winable)break;
				stb.append(next);
				programs = similarPrograms(programs, next, gamesPlayed);
				gamesPlayed++;
			}

			System.out.println(winable?stb.toString():"IMPOSSIBLE");
		}
	}

	private static String[] similarPrograms(String[] programs, String next, int gamesPlayed) {
		ArrayList<String> challengers = new ArrayList<>();

		for(int i = 0; i < programs.length; i++){
			if(programs[i].charAt(gamesPlayed%programs[i].length()) == next.charAt(0)){
				challengers.add(programs[i]);
			}
		}

		String nextChall [] = new String[challengers.size()];

		return challengers.toArray(nextChall);
	}

	private static String nextMove(String[] programs, int gamesPlayed) {
		HashSet<String> movesmade = new HashSet<>();
		for(int i = 0; i < programs.length; i++) {
			movesmade.add(String.valueOf(programs[i].charAt(gamesPlayed%programs[i].length())));
		}

		String nextMove = "";
		int numMovesMade = 0;
		int r = 0;
		int s = 0;
		int p = 0;

		if(movesmade.contains("S")) { numMovesMade++; s++;}

		if(movesmade.contains("R")) {numMovesMade++; r++;}

		if(movesmade.contains("P")) {numMovesMade++; p++;}

		if(numMovesMade == 3) {return nextMove = "";}
		if(numMovesMade == 2) {
			if(r > 0 && p > 0) return "P";
			if(r > 0 && s > 0) return "R";
			if(s > 0 && p > 0) return "S";
		}

		if(numMovesMade == 1) {
			if(p > 0) return "S";
			if(s > 0) return "R";
			if(r > 0) return "P";
		}

		return nextMove;
	}
}