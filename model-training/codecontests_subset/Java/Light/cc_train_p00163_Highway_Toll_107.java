
import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	Scanner sc = new Scanner(System.in);

	void run() {
		boolean m[][] = new boolean[8][8];
		m[7][1] = true;
		m[7][2] = true;
		m[7][3] = true;
//		m[7][4] = true;
		m[6][1] = true;
		
		int p[][] = new int[8][8];
		p[1][2] = 300;
		p[1][3] = 500;
		p[1][4] = 600;
		p[1][5] = 700;
		p[1][6] = 1350;
		p[1][7] = 1650;
		p[2][3] = 350;
		p[2][4] = 450;
		p[2][5] = 600;
		p[2][6] = 1150;
		p[2][7] = 1500;
		p[3][4] = 250;
		p[3][5] = 400;
		p[3][6] = 1000;
		p[3][7] = 1350;
		p[4][5] = 250;
		p[4][6] = 850;
		p[4][7] = 1300;
		p[5][6] = 600;
		p[5][7] = 1150;
		p[6][7] = 500;
		
		for(;;){
			int n = sc.nextInt();
		      
			if(n == 0){
				break;
			}
			
			int t1 = sc.nextInt()*60+sc.nextInt();
			
			int mz = sc.nextInt();
			int t2 = sc.nextInt()*60 + sc.nextInt();
			
			boolean h = false;
			if(t1 >= 17*60 + 30 && t1 <= 19*60 + 30){
				h = true;
			}
			if(t2 >= 17*60 + 30 && t2 <= 19*60 + 30){
				h = true;
			}
			int a = Math.max(n, mz);
			int b = Math.min(n , mz);
			
			if(m[a][b]){
				h = false;
			}
			
			int pr = p[b][a];
			
			if(h){
				if(pr % 100 == 0){
					System.out.println(pr/2);
				}else{
					System.out.println((pr-50)/2+50);
				
				}
			}else{
				System.out.println(pr);
			}
			
		}

	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

}