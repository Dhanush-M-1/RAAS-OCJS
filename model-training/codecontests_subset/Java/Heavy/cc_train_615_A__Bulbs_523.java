//package div338;
import java.io.*;
import java.util.*;
public class A 
{
	StringTokenizer st;
	BufferedReader in;
	PrintWriter ob;
	public static void main(String args[])throws IOException {
		new A().run();
	}
	void run()throws IOException   {
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve()throws IOException {
		read();
		int n=ni();
		int m=ni();
		int a[]=new int[m+1];
		for(int i=1;i<=n;i++)
		{
			read();
			int x=ni();
			for(int j=1;j<=x;j++)
				a[ni()]+=1;
		}
		boolean ans=true;
		for(int i=1;i<=m;i++){
			if(a[i]==0)
				ans=false;
		}
			ob.println(ans?"YES":"NO");
	}
	void read()throws IOException  {
		st=new StringTokenizer(in.readLine());
	}
	int ni(){
		return Integer.parseInt(st.nextToken());
	}
	long nl(){
		return Long.parseLong(st.nextToken());
	}
	double nd(){
		return Double.parseDouble(st.nextToken());
	}
	String ns(){
		return st.nextToken();
	}
	char nc(){
		return st.nextToken().charAt(0);
	}
	int[] nia(int n)throws IOException {
		int a[]=new int[n];
		read();
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(st.nextToken());
		}
		return a;
	}
	long[] nla(int n)throws IOException {
		long a[]=new long[n];
		read();
		for(int i=0;i<n;i++){
			a[i]=Long.parseLong(st.nextToken());
		}
		return a;
	}
}
