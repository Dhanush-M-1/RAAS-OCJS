import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class B20{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	
	private void solution() throws IOException {
		double a=nextInt();
		double b=nextInt();
		double c=nextInt();
		if(a==0 && b==0 && c==0){System.out.println(-1);System.exit(0);}
		if(a==0 && b==0){System.out.println(0);System.exit(0);}
		if(a==0){System.out.println(1);System.out.println(-c/b);System.exit(0);}
		double d=b*b-4*a*c;
		int k=0;
		if(d<0){k=0;}
		if(d==0){k=1;}
		if(d>0){k=2;}
		if(k==0){System.out.println(0);System.exit(0);}
		System.out.println(k);
		if(k==1){System.out.println((-b+Math.sqrt(d))/(2*a));}
		if(k==2){double ans =(-b-Math.sqrt(d))/(2*a);
		double ans1=(-b+Math.sqrt(d))/(2*a);
		if(ans>ans1){
			System.out.println(ans1);
			System.out.println(ans);
		}else{
			System.out.println(ans);
			System.out.println(ans1);
		}
		}
	}

	String nextToken() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(bf.readLine());
		}
		return st.nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public static void main(String args[]) throws IOException {
		new B20().solution();
	}
	
}