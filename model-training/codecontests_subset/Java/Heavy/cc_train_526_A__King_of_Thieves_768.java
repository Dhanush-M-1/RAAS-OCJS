//package tester;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Codeforces round 526, problem A: King of Thieves
 * 
 * @author annyni
 *
 */
public class cf526pA {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String level = sc.next();
		sc.close();
		
		char[] lvlArr = level.toCharArray(); 
		
		for (int j=0; j<n; j++) {
			if (lvlArr[j]=='.') continue;
			boolean luls = false;
			for (int i=1; j+4*i<n; i++) {
				if (lvlArr[j+i]=='*') {
					if (lvlArr[j+2*i]=='*') {
						if (lvlArr[j+3*i]=='*') {
							if (lvlArr[j+4*i]=='*') {
								luls = true;
							}
						}
					}
				} if (luls) break;
			}
			if (luls) {
				System.out.println("yes");
				return;
			}
		}
		
		System.out.println("no");
	}

}
