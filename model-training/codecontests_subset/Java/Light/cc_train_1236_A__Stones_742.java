

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int q=0;q<t;q++) {
			int a=scan.nextInt();
			int b=scan.nextInt();
			int c=scan.nextInt();
			int lol=a;
			int lol2=b;
			int x=Math.min(a,(b/2));
			int score=0;
			a-=x;
			b-=x*2;
			score=(3*score);
			if(b>0) {
				score+=3*Math.min(b,c/2);
			}
//			 System.out.println(score);
			int ans1=score;
			 a=lol;b=lol2;
				
			 score=Math.min(b,(c/2));
			
			b-=score;
			c-=score*2;
			score+=2*score;
			if(b>0) {
				score+=3*Math.min(a,b/2);
			}
//			 System.out.println(score);
			System.out.println(Math.max(score,ans1));
			 
		}
	}
}
