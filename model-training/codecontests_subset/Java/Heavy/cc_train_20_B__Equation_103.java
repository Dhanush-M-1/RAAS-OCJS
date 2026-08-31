import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public final class Main{//CF //B.Equation.
	static long mod = (long)(10e9+7);
	static BufferedReader br;
	static PrintWriter pw;
	static StringBuilder OUTPUT;
	public static void main(String[] args)throws Exception{
		OUTPUT = new StringBuilder("");
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out,true);//auto flush enabled....
		new Main().timer();
		br.close();
		pw.close();
	}
	public static void timer()throws Exception{
		long S = System.currentTimeMillis();
		solve();
		long E = System.currentTimeMillis();
		//pw.println("Time elapsed : "+(E-S)+" ms.");
	}
	public static void solve()throws Exception{
		String[] s;
		int t = 1;
		//int t = Integer.parseInt(br.readLine());
		for(int I=0;I<t;I++){
			//code from here....
			s = br.readLine().split("\\s+");
			double a = Integer.parseInt(s[0]);
			double b = Integer.parseInt(s[1]);
			double c = Integer.parseInt(s[2]);
			
			//checking for roots...
			if(a==0 && b==0 && c==0){
				pw.println("-1");
				return;
			}else if(a==0 && b==0){
				pw.println(0);
				return;
			}else if(a==0){
				pw.println("1");
				pw.println(-c/b);
				return;
			}
			double del = (b*b - 4f*a*c);
			
			if(del<0){
				pw.println(0);
				return;
			}else{
				double r1 = (-b+Math.sqrt(b*b-4f*a*c))/(2f*a);
				double r2 = (-b-Math.sqrt(b*b-4f*a*c))/(2f*a);
				
				if(r1==r2){
					pw.println(1);
					pw.println(r1);
				}else{
					pw.println(2);
					pw.println(Math.min(r1,r2));
					pw.println(Math.max(r1,r2));
				}
			}
		}
	}
}