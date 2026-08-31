import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;

import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class S2 {
	
	static class Reader {
		
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}
		
		static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}
		
	}
	
	static int[] merge(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		int [] c = new int[n+m];
		
		int j=0, k=0;
		while(j+k<m+n) {
			if(j>=m) {
				c[j+k] = b[k];
				k++;
			}
			else if(k>=n) {
				c[j+k] = a[j];
				j++;
			}
			else {
				if(a[j]<b[k]) {
					c[j+k] = a[j];
					j++;
				}
				else if(a[j]==b[k]) {
					if(a[j]<b[k]) {
						c[j+k] = a[j];
						j++;
					}
					else {
						c[j+k] = b[k];
						k++;
					}
				}
				else {
					c[j+k] = b[k];
					k++;
				}
			}
		}
		return c;
	}
	
	static int[] Msort(int[] unsorted){
		int l = unsorted.length;
		
		if(l<=1) {
			return unsorted;
		}
		
		else {
			int[] Msorted = new int[l];
			int[] m1 = new int[l/2];
			int[] m2 = new int[l-(l/2)];
			
			for(int i=0; i<l; i++) {
				if(i<l/2) {
					m1[i] = unsorted[i];
				}
				else {
					m2[i-(l/2)] = unsorted[i];
				}
			}
			
			Msorted = merge(Msort(m1), Msort(m2));		
			
			return Msorted;
		}
		
	}
	
	private static int inf = 1<<27;
	private static long ans;
	private static int n;
	private static int k;
	private static int[] arr;
	private static int m;
	private static int[] d;
	private static int qwerty;
	
	public static void main(String[] args) throws IOException {
				
		ans = 0;
		qwerty = 1000000007;
		
		Reader.init(System.in);
		
		OutputStream out = new BufferedOutputStream(System.out);
		
		m=200001;
		
		d = new int[m+1];
		d[0] = 1;
		d[1] = 2;
		d[2] = 2;
		d[3] = 2;
		d[4] = 2;
		d[5] = 2;
		d[6] = 2;
		d[7] = 2;
		d[8] = 2;
		d[9] = 2;
		
		for(int i=10; i<m; i++) {
			int a = d[i-9];
			int b = d[i-10];
			
			int c = (a+b)%qwerty;
			
			d[i] = c;
		}
		
		
		int t=1;
		t = Reader.nextInt();
		
		main_loop:
		for(int tn=0; tn<t; tn++) {
			
			ans=0;
			n=0;
			n = Reader.nextInt();
			m = Reader.nextInt();
			
			while(n>0) {
				int x = n%10;
				
				int y = 9-x;
				
				if(m>=y) {
					modulo(d[m-y]);
				}
				else {
					modulo(1);
				}
				
				n/=10;
			}
			
		//	out.write(("YES\n").getBytes());
		//	out.write(("NO\n").getBytes());
			out.write((ans+"\n").getBytes());
			
		}
		
		out.flush();
		out.close();
		
	}

	private static void fill(int m) {
		
		int qwerty = 1000000007;
		
		int a = d[m-9];
		int b = d[m-10];
		
		int c = (a+b)%qwerty;

	}

	private static void modulo(int x) {
		// TODO Auto-generated method stub
		ans += (long)x;
		ans %= 1000000007;
	}
	
	private static long rec(int x, int m) {
		
		int qwerty = 1000000007;
		
		int a = d[m-9];
		int b = d[m-10];
		
		int c = (a+b)%qwerty;
		
		int y = 10-x;
		
		if(m>=y) {
			m-=y;
			return ((rec(1, m))%qwerty)+((rec(0,m))%qwerty);
		}
		else {
			return 1;
		}
	}
}
