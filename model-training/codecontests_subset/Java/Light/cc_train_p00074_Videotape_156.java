import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main{

	Scanner sc;

	static final int INF=1<<28;
	static final double EPS=1e-9;

	void run(){
		sc=new Scanner(System.in);
		for(;;){
			int h=sc.nextInt();
			int m=sc.nextInt();
			int s=sc.nextInt();

			if(h==-1&&m==-1&&s==-1)
				break;

			h=2-h;
			m=0-m;
			s=0-s;

			if(s<0){
				s+=60;
				m--;
			}
			if(m<0){
				m+=60;
				h--;
			}

			println(String.format("%02d:%02d:%02d", h, m, s));

			h*=3;
			m*=3;
			s*=3;
			m+=s/60;
			s%=60;
			h+=m/60;
			m%=60;

			println(String.format("%02d:%02d:%02d", h, m, s));

		}
		sc.close();
	}

	void print(String s){
		System.out.print(s);
	}

	void println(String s){
		System.out.println(s);
	}

	public static void main(String[] args){
		new Main().run();
	}
}