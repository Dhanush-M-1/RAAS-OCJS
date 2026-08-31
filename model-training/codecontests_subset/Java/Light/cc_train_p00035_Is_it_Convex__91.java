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
		for(; sc.hasNext();){
			String[] s=sc.nextLine().split(",");
			double[] x=new double[4];
			double[] y=new double[4];
			for(int i=0; i<4; i++){
				x[i]=Double.parseDouble(s[i*2]);
				y[i]=Double.parseDouble(s[i*2+1]);
			}
			int[] signs=new int[4];
			for(int k=0; k<4; k++){
				int i=(k+1)%4;
				int j=(k+3)%4;
				double vx1=x[i]-x[k];
				double vy1=y[i]-y[k];
				double vx2=x[j]-x[k];
				double vy2=y[j]-y[k];
				double det=vx1*vy2-vy1*vx2;
				if(det<-EPS)
					signs[i]=-1;
				else
					signs[i]=1;
			}
			boolean f=true;
			for(int i=0; i<3; i++)
				if(signs[i]!=signs[i+1])
					f=false;
			println(f?"YES":"NO");
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