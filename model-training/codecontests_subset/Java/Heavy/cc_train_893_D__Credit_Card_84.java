// package codeforces;
import java.util.*;
import java.io.*;
public class D {
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int d=sc.nextInt();
		int [] a=new int [n];
		int [] max=new int [n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			if(i>0)
				a[i]+=a[i-1];
			max[i]=d-a[i];
		}
		for(int i=n-2;i>=0;i--)
			max[i]=Math.min(max[i], max[i+1]);
		for(int i=0;i<n;i++)
			if(a[i]>d){
				System.out.println(-1);
				return;
			} 
		boolean ok=true;
		int cnt=0;
		int add=0;
		for(int i=1;i<n;i++){
			if(a[i]+add<0 && a[i]==a[i-1]){
				cnt++;
				if(a[i]+max[i-1]<0)
					ok=false;
				add=max[i-1];
			}
		}
		if(!ok)
			pw.println(-1);
		else
			pw.println(cnt);
		pw.flush();
		pw.close();
	}
	
	
	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		MyScanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while(st==null || !st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		long nextLong(){
			return Long.parseLong(next());
		}
	}
}
