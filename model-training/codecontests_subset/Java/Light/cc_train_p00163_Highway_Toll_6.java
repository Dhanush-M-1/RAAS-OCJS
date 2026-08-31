import java.util.*;
public class Main{
	static int[][] m = new int[][] {{0,300,500,600,700,1350,1650},
									{0,  0,350,450,600,1150,1500},
									{0,  0,  0,250,400,1000,1350},
									{0,  0,  0,  0,250, 850,1300},
									{0,  0,  0,  0,  0, 600,1150},
									{0,  0,  0,  0,  0, 0,  500},
									{0,0,0,0,0,0,0}
								   };
	static int[][] l = new int[][] {{0,6,13,18,23,43,58},
									{0,0,7 ,12,17,37,52},
									{0,0,0 ,5 ,10,30,45},
									{0,0,0 ,0 ,5 ,25,40},
									{0,0,0 ,0 ,0 ,20,35},
									{0,0,0 ,0 ,0 ,0 ,15},
									{0,0,0 ,0 ,0 ,0 ,0 }
								   };
	public static void main(String[]agrs){
		Scanner sc = new Scanner(System.in);
		while(true) {
			int s = sc.nextInt();
			if(s == 0) break;
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int g = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int len = l[s-1][g-1];
			int mon = m[s-1][g-1];
			
			if(len <= 40 && ((h1*60 + m1) >= (17*60 + 30) || (h2*60 + m2) <= (19*60 + 30))) {
				mon /= 2;
			}
			if(mon % 50 != 0) {
				mon += 50 - (mon % 50);
			}
			System.out.println(mon);
		}
	}
}