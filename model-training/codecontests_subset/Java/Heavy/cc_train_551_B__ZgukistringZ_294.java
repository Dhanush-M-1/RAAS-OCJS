import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
public class C {
	static int [] a,b,c;
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out,true);
		
		int x=0,y=0,max=0;
		a=new int [26];
		b=new int [26];
		c=new int [26];
		String sa=sc.next();
		for(int i=0;i<sa.length();i++) a[sa.charAt(i)-'a']++;
		String sb=sc.next();
		for(int i=0;i<sb.length();i++) b[sb.charAt(i)-'a']++;
		String scc=sc.next();
		for(int i=0;i<scc.length();i++) c[scc.charAt(i)-'a']++;
		
		for(int i=0;i<=sa.length();i++){
			if(possible(i)){
				int j=Integer.MAX_VALUE;
				for(int k=0;k<26;k++){
					if(c[k]>0)
						j=Math.min(j, (a[k]-i*b[k])/c[k]);
				}
				if(i+j>max){
					max=i+j;
					x=i;
					y=j;
				}
			}else
				break;
		}
		
		for(int i=0;i<26;i++)
			a[i]-=(x*b[i]+y*c[i]);
		
		while(x-->0) pw.print(sb);
		while(y-->0) pw.print(scc);
		for(int i=0;i<26;i++)
			while(a[i]-->0) pw.print((char)(i+'a'));
		pw.println();
		pw.flush();
		pw.close();
	}
	
	public static boolean possible(int x){
		for(int i=0;i<26;i++)
			if(a[i]<b[i]*x)
				return false;
		return true;
	}
	
	static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
}
