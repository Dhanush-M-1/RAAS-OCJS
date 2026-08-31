import java.io.*;
import java.util.*;
public class div313Dnew
{
	BufferedReader in;
	PrintWriter ob;
	StringTokenizer st;
	char a[],b[];
	public static void main(String[] args)  throws IOException { 
		new div313Dnew().run();
	}
	void run() throws IOException {
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve() throws IOException {
		a=ns().toCharArray();
		b=ns().toCharArray();
		int l=a.length;
		int m=b.length;
		if(equ(0,l-1,0,m-1))
			ob.println("YES");
		else
			ob.println("NO");
	}
	boolean equ(int s1,int s2,int c,int d) {
		if(s2<s1 || d<c) return false;
		if(equal(s1,s2,c,d)) return true;
		if((s2-s1+1)%2!=0) return false;
		int m1=s1+(s2-s1+1)/2 -1;
		int m2=c+(d-c+1)/2 -1;
		return (  (equ(s1,m1,m2+1,d) && equ(m1+1,s2,c,m2)) ||  (equ(s1,m1,c,m2) && equ(m1+1,s2,m2+1,d)) );

	}
	boolean equal(int s1,int s2,int c,int d) {
		if((s2-s1)==(d-c)){
			for(int i=s1,j=c;i<=s2 && j<=d ;i++ ,j++)
					if(a[i]!=b[j])
						return false;
			return true;
		}
		return false;
	}
	String ns() throws IOException {
		return nextToken();
	}
	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}
	String nextToken() throws IOException {
		if(st==null || !st.hasMoreTokens())
			st=new StringTokenizer(in.readLine());
		return st.nextToken();
	}
}