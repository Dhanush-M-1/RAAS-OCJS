import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main{

	Scanner sc=new Scanner(System.in);

	int INF=1<<28;
	double EPS=1e-9;

	void run(){
		int[][] d={
		//
				{0, 6, 13, 18, 23, 43, 58}, //
				{6, 0, 7, 12, 17, 37, 52}, //
				{13, 7, 0, 5, 10, 30, 45}, //
				{18, 12, 5, 0, 5, 25, 40}, //
				{23, 17, 10, 5, 0, 20, 35}, //
				{43, 37, 30, 25, 20, 0, 15}, //
				{58, 52, 45, 40, 35, 15, 0}, //
		};
		int[][] c={
				{0, 300, 500, 600, 700, 1350, 1650},
				{300, 0, 350, 450, 600, 1150, 1500},
				{500, 350, 0, 250, 400, 1000, 1350},
				{600, 450, 250, 0, 250, 850, 1300},
				{700, 600, 400, 250, 0, 600, 1150},
				{1350, 1150, 1000, 850, 600, 0, 500},
				{1650, 1500, 1350, 1300, 1150, 500, 0},};

		for(;;){
			int ic1=sc.nextInt()-1;
			if(ic1==-1){
				break;
			}
			int h1=sc.nextInt();
			int m1=sc.nextInt()+h1*60;
			int ic2=sc.nextInt()-1;
			int h2=sc.nextInt();
			int m2=sc.nextInt()+h2*60;

			int s=17*60+30;
			int g=19*60+30;
			int ans=c[ic1][ic2];
			if((s<=m1&&m1<=g)||(s<=m2&&m2<=g)){
				if(d[ic1][ic2]<=40){
					// ツ板シツ額
					ans=(int)(Math.ceil(ans/2./50.)*50+EPS);
				}
			}
			println(""+ans);
		}
	}

	void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}

	void print(String s){
		System.out.print(s);
	}

	void println(String s){
		System.out.println(s);
	}

	public static void main(String[] args){
		// System.setOut(new PrintStream(new BufferedOutputStream(System.out)));
		new Main().run();
	}
}