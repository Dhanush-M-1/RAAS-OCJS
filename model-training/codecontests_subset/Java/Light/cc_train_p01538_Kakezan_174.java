import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class Main{
	Scanner sc=new Scanner(System.in);

	int INF=1<<28;
	double EPS=1e-12;

	int n;

	void run(){
		int q=sc.nextInt();
		for(int i=0; i<q; i++){
			n=sc.nextInt();
			solve();
		}
	}

	void solve(){
		int step;
		for(step=0; n>=10; step++){
			String s=n+"";
			n=0;
			for(int i=1; i<s.length(); i++){
				int p=Integer.parseInt(s.substring(0, i));
				int q=Integer.parseInt(s.substring(i, s.length()));
				n=max(n, p*q);
			}
		}
		println(step+"");
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
		new Main().run();
	}
}