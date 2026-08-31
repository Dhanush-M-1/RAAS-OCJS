import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
 
public class Main {
	public static void main(String args[])throws IOException  {
 
	
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		long ans = 1;
		long n=in.nextLong();
		long p=in.nextLong();
		ans = findAns(n,p,out);
		/*
		for(int j=0;j<1;j++){
			long n =  Math.round(Math.random()*Math.pow(10, 11)); 
			long p =  Math.round(Math.random()*Math.pow(10, 11)); 

			ans = findAns(n,p);
			out.println(n+" "+p+ " " + ans);	
		}
		*/
		out.print(ans);
		out.close();
	}
	
	public static long findAns(long n, long p,PrintWriter out){
		long ans = 1;

		ArrayList index = new ArrayList();
		ArrayList numCount = new ArrayList();
		
		//find the prime factors
		int count = 0;
		while(p%2 ==0){	
			count++;
			p = p/2;
		}

		if(count>0){
			index.add(2L);
			numCount.add(count);

		}
		
		long cur =3L;
	
		while(cur*cur <=p){
			count=0;
			while(p%cur ==0){	
				count++;
				p = p/cur;
			}
			if(count>0){
				index.add(cur);
				numCount.add(count);
			}		
			cur = cur+2;
			if(p==1)break;
		}
		
		if(p!=1){
				index.add(p);
				numCount.add(1);		
		}

		for(int j=0; j<numCount.size();j++){

			int temp = (int)Math.floor((int)numCount.get(j)/n);

			if(temp>0){
				ans = ans * (long)Math.pow((long)index.get(j),temp);

			}
		}	
		return ans;
	}	
	
	
	static class InputReader {
		BufferedReader in;
		StringTokenizer tok;
 
		public String nextString() {
			while (!tok.hasMoreTokens()) {
				try {
					tok = new StringTokenizer(in.readLine(), " ");
				} catch (IOException e) {
					throw new InputMismatchException();
				}
			}
			return tok.nextToken();
		}
 
		public int nextInt() {
			return Integer.parseInt(nextString());
		}
 
		public long nextLong() {
			return Long.parseLong(nextString());
		}
 
		public double nextDouble() {
			return Double.parseDouble(nextString());
		}
 
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for (int i = 0; i < n; i++) {
				res[i] = nextInt();
			}
			return res;
		}
 
		public int[] nextIntArrayDec(int n) {
			int[] res = new int[n];
			for (int i = 0; i < n; i++) {
				res[i] = nextInt() - 1;
			}
			return res;
		}
 
		public int[] nextIntArray1Index(int n) {
			int[] res = new int[n + 1];
			for (int i = 0; i < n; i++) {
				res[i + 1] = nextInt();
			}
			return res;
		}
 
		public long[] nextLongArray(int n) {
			long[] res = new long[n];
			for (int i = 0; i < n; i++) {
				res[i] = nextLong();
			}
			return res;
		}
 
		public long[] nextLongArrayDec(int n) {
			long[] res = new long[n];
			for (int i = 0; i < n; i++) {
				res[i] = nextLong() - 1;
			}
			return res;
		}
 
		public long[] nextLongArray1Index(int n) {
			long[] res = new long[n + 1];
			for (int i = 0; i < n; i++) {
				res[i + 1] = nextLong();
			}
			return res;
		}
 
		public double[] nextDoubleArray(int n) {
			double[] res = new double[n];
			for (int i = 0; i < n; i++) {
				res[i] = nextDouble();
			}
			return res;
		}
 
		public InputReader(InputStream inputStream) {
			in = new BufferedReader(new InputStreamReader(inputStream));
			tok = new StringTokenizer("");
		}
	}
 
	
}
