// Working program with FastReader 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.lang.model.util.ElementScanner6;

import java.util.*;
import java.io.*;


public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	/*
	 * static void check(int a[]){ int max=a[0]; int countMax=0; int count=1; int
	 * temp=max; for(int aa:a){ System.out.print(aa+" "); } for(int
	 * i=1;i<a.length;++i){ temp=max; max=Math.max(max,a[i]); if(max!=temp){
	 * count=1; temp=max; } else ++count; countMax=Math.max(countMax,count); } int
	 * Min=Integer.MAX_VALUE; int count2=0; for(int i=0;i<a.length-1;++i){ count2=0;
	 * for(int j=i+1;j<a.length;++j){ if(a[i]>a[j]){ ++count } } }
	 */
static int checkl(int a[],int index){
	
	int count=0;
 for(int i=index-1;i>=0;--i){
	if(a[index]-a[i]!=0){
		float fl=(index+1)-(i+1);
		float fff=a[i]-a[index];
	   if(fl>=0&&fff>=0){
		   ++count;
	   }
 }
}
return count;

}
static int checkr(int a[],int index){
	
	//formula i2-i1/v1-v2
	int term=index+1;
	int count=0;
	for(int i=index+1;i<a.length;++i){
         if(a[index]-a[i]!=0){
			 float fl=(i+1)-(index+1);
			 float fff=a[index]-a[i];
			if(fl>=0&&fff>=0){
				++count;
			}
		 }
	}
	return count;
}
	public static void main(String[] args) {
 FastReader scan=new FastReader();
 int t=scan.nextInt();
 int count=0;
 int count1=0;
 int temp=t;
while(t-->0){
  int n=scan.nextInt();
  if(n==100)
  ++count;
  else
  ++count1;
} 
if(count%2!=0){
	System.out.println("NO");
}
else
if(count1%2==1&&count==0){
	System.out.println("NO");
}
else 
System.out.println("YES");


	
}}