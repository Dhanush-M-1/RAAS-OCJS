//package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class MathProblem {
	public static void main(String args[]) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		for(int t1=0;t1<t;t1++) {
			int n=fs.nextInt();
			int [][]arr=new int[n][2];
			
			int max=Integer.MIN_VALUE;
			int min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				arr[i][0]=fs.nextInt();
				arr[i][1]=fs.nextInt();
				max=Math.max(max, arr[i][0]);
				min=Math.min(min, arr[i][1]);
			}
			System.out.println(Math.max(0, max-min));
		}
	}
	static final Random random=new Random();	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
