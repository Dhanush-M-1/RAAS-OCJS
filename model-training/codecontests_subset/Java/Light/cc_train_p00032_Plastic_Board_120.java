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
		int rectangle=0;
		int diamond=0;
		for(;sc.hasNext();){
//		for(int i=0;i<4;i++){
			String[] s=sc.nextLine().split(",");
			int e1=Integer.parseInt(s[0]);
			int e2=Integer.parseInt(s[1]);
			int d=Integer.parseInt(s[2]);
			if(e1*e1+e2*e2==d*d){
				rectangle++;
			}else if(e1==e2&&e1+e2>d){
				diamond++;
			}
		}
		println(rectangle+"");
		println(diamond+"");
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