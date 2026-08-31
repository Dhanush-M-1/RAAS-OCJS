import java.io.*;
import java.math.BigInteger;
import java.util.*;

import javax.rmi.CORBA.Util;
import javax.swing.text.Utilities;



public class Main {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;		
		OutputStream outputStream = System.out;		
		PrintWriter out = new PrintWriter(outputStream);
		InputReader in = new InputReader(inputStream);
		//InputStream uinputStream = new FileInputStream("hayfeast.in");
		//InputReader in = new InputReader(uinputStream);
		//PrintWriter uout = new PrintWriter(new BufferedWriter(new FileWriter("hayfeast.out")));

		Task t = new Task();
		t.solve(in, out);
		out.close();
	}
	
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}		

	static class Task {		
		public void solve(InputReader in, PrintWriter out) throws IOException {
			long tStart = System.currentTimeMillis();
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int hole[] = new int[n+1];
			for(int i=0;i<m;i++) hole[in.nextInt()] = 1;
			int lst[] = new int[n];
			for(int i=0;i<n;i++){
				if(hole[i]==0) lst[i]=i;
				else if(i>0){
					lst[i] = lst[i-1];
				}else{
					lst[i]=-1;
				}
			}
			
			int price[] = new int[1000001];
			for(int i=1;i<=k;i++){
				price[in.nextInt()] = i;
			}			
			ArrayList<pair> q = new ArrayList<pair>();
			for(int i=1;i<1000001;i++){
				if(price[i]!=0)
					q.add(new pair(price[i],i));
			}
			long min = Long.MAX_VALUE;
			for(pair t:q){
				long cost = is_ok(hole,lst,n,t);
				if(cost!=-1&&cost<min) min = cost;
			}
			out.println(min==Long.MAX_VALUE?-1:min);			
		}
		class pair{
			int len, price;
			public pair(int a, int b){
				len=a;price=b;
			}		
		}
		long is_ok(int[] hole, int[] lst, int end, pair t){
			int c=0; int prev = -1; int cur=0;		
			while(cur<end){
				if(lst[cur]<=prev) return -1;
				prev = lst[cur];
				cur = prev+t.len;
				c++;
			}
			return (long)c*t.price;
		}
	}

	// default class
	static class InputReader {
		public BufferedReader re;
		public StringTokenizer st;

		public InputReader(InputStream input) {
			re = new BufferedReader(new InputStreamReader(input));
			st = null;
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(re.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

			}
			return st.nextToken();
		}

		public String nextLine() {
			String tmp = null;
			try {
				tmp = re.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return tmp;
		}

		public boolean hasNext() {
			String tmp;
			if (st != null && st.hasMoreTokens())
				return true;
			else {
				try {
					tmp = re.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				if (tmp != null) {
					st = new StringTokenizer(tmp);
					return true;
				} else {
					return false;
				}
			}

		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

	static class Dumper {
		static void print_int_arr(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.println("---------------------");
		}
		
		static void print_char_arr(char[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.println("---------------------");
		}		

		static void print_double_arr(double[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.println("---------------------");
		}

		static void print_2d_arr(int[][] arr, int x, int y) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("---------------------");
		}

		static void print_2d_arr(boolean[][] arr, int x, int y) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("---------------------");
		}

		static void print(Object o) {
			System.out.println(o.toString());
		}

		static void getc() {
			System.out.println("here");
		}
		
		static void print_listnode(ListNode x){
			while(x!=null){
				System.out.print(x.val+" ");
				x=x.next;
			}
			System.out.println();
		}
	}
}