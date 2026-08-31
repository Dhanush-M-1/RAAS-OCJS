import java.util.*;

import java.lang.*;

import java.math.*;



public class Main {

	Scanner sc = new Scanner(System.in);

	void run(){

		for(;;){

			int h=sc.nextInt();

			int m=sc.nextInt();

			int s=sc.nextInt();

			if(h==-1&&m==-1&&s==-1) break;

			int ns = -s;

			while(ns<0){

				m+=1;

				ns+=60;

			}

			int nm = -m;

			while(nm<0){

				h+=1;

				nm += 60;

			}

			int nh=2-h;

			System.out.printf("%02d:%02d:%02d",nh,nm,ns);

			System.out.println();

			ns = ns*3;

			int nm2=0;

			while(ns>=60){

				nm2+=1;

				ns-=60;

			}

			nm = nm*3+nm2;

			int nh2=0;

			while(nm>=60){

				nh2+=1;

				nm-=60;

			}

			nh=nh*3+nh2;

			System.out.printf("%02d:%02d:%02d",nh,nm,ns);

			System.out.println();

		}

		

	}

	public static void main(String[] args){

		Main m = new Main();

		m.run();

	}

}