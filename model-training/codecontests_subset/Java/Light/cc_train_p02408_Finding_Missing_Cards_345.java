import java.awt.*;
import java.awt.geom.*;
import java.io.*;

import java.util.*;
class Main {

	static char[] xx = new char[] {'S','H','C','D'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] l = new boolean[4][13];
		for(int i = 0; i < n; i++) {
			char k = sc.next().charAt(0);
			int r = sc.nextInt();
			if(k == 'S') {
				l[0][r-1] = true;
			}
			if(k == 'H') {
				l[1][r-1] = true;
			}
			if(k == 'C') {
				l[2][r-1] = true;
			}
			if(k == 'D') {
				l[3][r-1] = true;
			}
		}
		for(int i = 0 ; i< 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(!l[i][j]) {
					System.out.println(xx[i] + " " + (j+1));
				}
			}
		}
	}
}