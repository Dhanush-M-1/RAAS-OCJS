/*
ID: andrew42
LANG: JAVA
TASK: 
PROG: 
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class chess {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numGames = input.nextInt();
		int curSpec = 3;
		boolean poss = true;
		for (int i = 0; i < numGames; i++){
			int winner = input.nextInt();
			if (winner == curSpec){
				poss = false; break;
			}
			if (curSpec == 1){
				if (winner == 2) curSpec = 3; else curSpec = 2;
			} else if (curSpec == 2) {
				if (winner == 1) curSpec = 3; else curSpec = 1;
			} else {
				if (winner == 1) curSpec = 2; else curSpec = 1;
			}
		}
		if (poss) System.out.println("YES"); else System.out.println("NO");
	}
}
