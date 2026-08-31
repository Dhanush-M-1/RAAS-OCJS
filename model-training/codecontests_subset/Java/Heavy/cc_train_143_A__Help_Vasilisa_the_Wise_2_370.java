//package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {

	 static int r1,r2,c1,c2,d1,d2;
	 
	static boolean check(int x00,int x01,int x10,int x11){
		return(x00+x01==r1&&x10+x11==r2&&x00+x10==c1&&x01+x11==c2
				&&x00+x11==d1&&x01+x10==d2);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		r1 = in.nextInt();
		r2 = in.nextInt();
		c1 = in.nextInt();
		c2 = in.nextInt();
		d1 = in.nextInt();
		d2 = in.nextInt();
		
		for(int x00=1;x00<10;x00++){
			for(int x01=1;x01<10;x01++){
				if(x00==x01)continue;
				for(int x10=1;x10<10;x10++){
					if(x10==x00||x10==x01)continue;
					for(int x11=1;x11<10;x11++){
						if(x11==x00||x11==x10||x11==x01)continue;
						if(check(x00,x01,x10,x11)){
							System.out.println(x00+" "+x01);
							System.out.println(x10+" "+x11);
							return ;
						}
					}
				}
			}
		}
		
		System.out.println(-1);
		 
	}
}
