// package codeforces;
import java.util.*;
import java.io.*;
public class CF494_D1_A {
	public static void main(String[] args) {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		char [] s=sc.next().toCharArray();
		int n=s.length;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		int cnt=0,cntH=0;
		for(int i=0;i<n;i++){
			if(s[i]=='(')
				cnt++;
			else
				if(s[i]==')')
					cnt--;
				else
					cntH++;
		}
		if(cnt<cntH)
			pw.println(-1);
		else{
			for(int i=0;i<cntH-1;i++)
				arr.add(1);
			arr.add(cnt-cntH+1);
			cnt=0;
			int p=0;
			boolean ok=true;
			for(int i=0;i<n;i++){
				if(s[i]=='(')
					cnt++;
				else
					if(s[i]==')')
						cnt--;
					else
						cnt-=arr.get(p++);
				if(cnt<0)
					ok=false;
			}
			if(ok){
				for(int x : arr)
					pw.println(x);
			}else
				pw.println(-1);
		}
		
		
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
