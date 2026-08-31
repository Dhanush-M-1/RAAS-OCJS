
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

public class Round659 {

	static int ans=0;
	static int rec=0;
	static int X[] = { -1, 0, 0, 1 };
	static int Y[] = { 0, -1, 1, 0 };

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static long[] initArray(int n, Reader scan) throws IOException {

		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextLong();
		}

		return arr;
	}

	public static long sum(long arr[]) {

		long sum = 0;
		for (long i : arr) {
			sum += (long) i;
		}

		return sum;
	}

	public static long max(long arr[]) {

		long max = Long.MIN_VALUE;

		for (long i : arr) {
			max = Math.max(i, max);
		}

		return max;
	}

	public static long min(long arr[]) {
		long min = Long.MAX_VALUE;

		for (long i : arr) {
			min = Math.min(i, min);
		}

		return min;
	}

	public static List<Integer>[] initAdjacency(int n, int e, Reader scan, boolean type) throws IOException {

		List<Integer> adj[] = new ArrayList[n + 1];

		for (int i = 0; i < e; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();

			if (adj[u] == null)
				adj[u] = new ArrayList<>();
			if (type && adj[v] == null)
				adj[v] = new ArrayList<>();

			adj[u].add(v);

			if (type)
				adj[v].add(u);

		}

		return adj;
	}
	public static void main(String[] args) throws IOException {
		
		Reader scan=new Reader();
//		Scanner scan=new Scanner(System.in);
		
		
		int t=scan.nextInt();
		while(t-->0) {
			int n=scan.nextInt();
//			int d=scan.nextInt();
//			int m=scan.nextInt();
//			int m=scan.nextInt();
//			int k=scan.nextInt();
//			int l=scan.nextInt();
//			int arr[]=new int[n];
//			
//			for(int i=0;i<n;i++) {
//				arr[i]=scan.nextInt();
//			}
//			
			
//			int arr1[]=new int[n];
//
//			int arr2[]=new int[m];
//			
//			for(int i=0;i<n;i++) {
//				arr1[i]=scan.nextInt();
//			}
//			
//			for(int i=0;i<m;i++) {
//				arr2[i]=scan.nextInt();
//			}

			
			long arr[]=initArray(n, scan);
			A(n, arr);
		}

	
	}
	
	public static void A(int n, long arr[]) {
		
		
		long a=arr[0];
		long b=arr[1];
		
		for(int i=2;i<n;i++) {
			
			if(a+b<=arr[i]) {
				
				System.out.println((1)+" "+(2)+" "+(i+1));
				return;
			}
			
		}
		
		System.out.println(-1);
		
	}
	
	public static boolean canTransform(long a, long b, long c) {
		
		if(a<=0||b<=0||c<=0) return false;
		
		return true;
		
	}
	
	public static void B(int n, int m, int x, int y) {
		
		int i=x;
		int j=y;
		
		while(i<=n) {
			System.out.println(i+" "+j);
			i++;
		}
		
		i=x-1;
		while(i>=1) {
			System.out.println(i+" "+j);
			i--;
		}
		i=1;
		rightZigZag(n, m, i, j);
		
		if((m-y)%2==0) {
			i=1;
		}else {
			i=n;
		}
		
		leftZigZag(n, m, i, j);
		
	}
	
	public static void rightZigZag(int n, int m, int i, int j) {
		
		if(j==m) {
			return;
		}
		

		j++;
		
		if(i==1) {
			
			while(i<=n) {
				System.out.println(i+" "+j);
				i++;
			}
			
			i=n;
		}else {
			
			while(i>=1) {
				System.out.println(i+" "+j);
				i--;
			}
			
			i=1;
			
		}
		
		rightZigZag(n, m, i, j);
		
	}
	
	public static void leftZigZag(int n, int m, int i, int j) {
		
		if(j==1) {
			return;
		}
		

		j--;
		
		if(i==1) {
			
			while(i<=n) {
				System.out.println(i+" "+j);
				i++;
			}
			
			i=n;
		}else {
			
			while(i>=1) {
				System.out.println(i+" "+j);
				i--;
			}
			
			i=1;
			
		}
		
		leftZigZag(n, m, i, j);
		
	}
	
	
	public static void C(int n, int m, int arr1[], int arr2[]) {
		
		
		int l=0;
		int h= (1<<9)-1;
		
		while(l<=h) {
			
			int mid= l+(h-l)/2;
			
			if(isPossible(n, m, arr1, arr2, mid)) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		
		System.out.println(l);
		
	}
	
	public static void D(int n, int d, long m, long arr[]) {
		
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int ns=0;
		for(long i: arr) {
			if(i<=m) {
				ns++;
			}else {
				break;
			}
		}
		
		long arr1[]=new long[ns];
		Long arr2[]=new Long[n-ns];
		long preSum[]=new long[ns];
		int i=0;
		int j=0;
		long last=0;
		for(long num: arr) {
			if(num<=m) {
				arr1[i]=num;
				preSum[i]= num+last;
				last=preSum[i];
				i++;
			}else {
				arr2[j++]=num;
			}
		}
		
		Arrays.sort(arr2, Collections.reverseOrder());
		
		int count= (int)Math.ceil(arr2.length/(double)(d+1));
		
		long ans=0;
		
		ans+= sum(arr1);
		
		
		i=0;
		
		while(i<count) {
			
			ans+= arr2[i];
			i++;
		}
		
		int rem= count*(d+1)-arr2.length;
		
		
		i=0;
		j=count;
		
		int it=1;
		while(j<arr2.length) {
		
			
			int req= rem+1;
			
			
			if(ns-i>=req) {
				
				long sum= preSum[i+req-1]- ((i==0)? 0: preSum[i-1]);
				
				
				if(sum>=arr2[j]) {
					break;
				}
				
				ans-= sum;
				ans+= arr2[j];
				i+=req;
				rem=d;
				j++;
				
				
				
			}else {
				break;
			}
			
			
		}
		
		System.out.println(ans);
		
	}
	
	public static boolean isPossible(int n, int m, int arr1[], int arr2[], int val) {
		
		
		for(int i=0;i<n;i++) {
			
			boolean found=false;
			
			for(int j=0;j<m;j++) {
				
				int num= arr1[i]&arr2[j];
				
				int val1= num|val;
				
				if((val1^val)==0) {
					found=true;
					break;
				}
				
			}
			
			if(!found) return false;
		}
		
		return true;
		
		
	}
	
	
	
	public static void B(int n, int m, char arr[][]) {
		
		
		int ans=0;
		
		for(int j=0;j<m-1;j++) {
			if(arr[n-1][j]=='D') {
				ans++;
			}
		}
		
		for(int i=0;i<n-1;i++) {
			if(arr[i][m-1]=='R') {
				ans++;
			}
		}
		
		System.out.println(ans);
		
		
	}
	
	
	
	
	
	
	public static void D(int n,int m, String arr[]) {
		
		
		if(n>=4&&m>=4) {
			System.out.println(-1);
			return;
		}
		
		if(n==1||m==1) {
			System.out.println(0);
			return;
		}
		
		
		if(n==2) {
			
		}
		
	}
	
	
}
