//package zeptoLabCodeRush_20150403;

import java.util.Scanner;

public class Pb1 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		String str = in.next();
		char [] s = str.toCharArray();
		for(int i=1;i<=n/4;i++){// i = step length
			for(int j=0;j+4*i<n;j++){// j = starting point
				if(s[j]=='*'&&s[j+i]=='*'&&s[j+2*i]=='*'&&s[j+3*i]=='*'&&s[j+4*i]=='*'){
					System.out.println("yes");
					return;
					}
			}//for j
		}//for i
		System.out.println("no");
		return;
	}// main()

}// class
