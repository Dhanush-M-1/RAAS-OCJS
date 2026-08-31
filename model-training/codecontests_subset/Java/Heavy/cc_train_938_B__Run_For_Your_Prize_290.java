//package EducationalRound38;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
 
public class TaskB {
	public static void main(String[] args) throws java.lang.Exception{
		InputStream inputstream = System.in;
		OutputStream outputstream = System.out;
		InputReader in = new InputReader(inputstream);
		PrintWriter out = new PrintWriter(outputstream);
		Call one = new Call();
		one.solve(in,out);
		out.close();
	}
	static class Call {
		public void solve(InputReader in,PrintWriter out) {	
			int n = in.nextInt();
			boolean picked[]=new boolean [1000000];
			int a[]=new int[1000000];
			for(int i=0;i<n;i++) {
				int x =in.nextInt();
				picked[x]=true;
			}
			int count1=0;
			int count2=0;
			int count3=0;
			int count4=0;
			int l=2;
			int k=1000000-1;
			while(l<=k || count4<n) {
				count2++;
				if(picked[l]==true) {
					count4++;
					count1=(count2);
				}
				if(picked[k]==true) {
					count4++;
					count3=count2;
				}
				l++;
				k--;
			}
			/*
			for(int i=2,j=1000000-1;((i<=j)|| count4==n);i++,j--) {
				count2++;
				if(picked[i]==true) {
					count4++;
					count1+=(count2-count1);
				}	
				if(picked[j]==true) {
					count4++;
					count3+=(count2-count3);
				}
			}*/
			out.println(Math.max(count1, count3));
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader (stream),32768);
			tokenizer = null;
		}
		public String next() {
				while(tokenizer == null || !tokenizer.hasMoreElements()) {
					try {
						tokenizer = new StringTokenizer(reader.readLine());
					}
					catch(IOException e) {
						throw new RuntimeException(e);
					}
				}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}