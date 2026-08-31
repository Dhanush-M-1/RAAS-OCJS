//package Codeforces;

import java.util.*;
import java.io.*;

public class B {
	static final int mod = (int) 1e9 + 7;
	static final int inf = (int) 1e9;
	static final long INF = (long) 1e18;

	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		while (T-- > 0) {
			int n = fs.nextInt();
			char arr[][] = new char[n][n];
			ArrayList<pair> fir = new ArrayList<>();
			ArrayList<pair> sec = new ArrayList<pair>();
			for (int i = 0; i < n; i++) 
			{
				char str[] = fs.next().toCharArray();
				for (int j = 0; j < n; j++) 
				{
					arr[i][j] = str[j];
				}
			}
			fir.add(new pair(arr[0][1]-'0',arr[1][0]-'0'));
			sec.add(new pair(arr[n-1][n-2]-'0',arr[n-2][n-1]-'0'));
			pair one=fir.get(0);
			pair two=sec.get(0);
			//System.out.println(one.first+" "+one.second+" "+two.first+" "+two.second);
			if(one.first==one.second && two.first==two.second && one.first!=two.first)
			{
				System.out.println(0);
			}
			else if(one.first==one.second && two.first==two.second && one.first==two.first)
			{
				System.out.println(2);
				System.out.println((n)+" "+(n-1));
				System.out.println((n-1)+" "+(n));
			}
			else if(one.first==one.second)
			{
				System.out.println(1);
				System.out.println(two.first==one.first ? (n)+" "+(n-1):(n-1)+" "+(n));
			}
			else if(two.first==two.second)
			{
				System.out.println(1);
				System.out.println(one.first==two.first ? "1 2":"2 1");
			}
			else
			{
				System.out.println(2);
				System.out.println(n+" "+(n-1));
				System.out.println(one.first==two.second ? "1 2":"2 1");
			}
		}
	}
}
class pair
{
	int first,second;
	pair(int first,int second)
	{
		this.first=first;this.second=second;
	}
}
class FastScanner {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer("");

	public String next() {
		while (!st.hasMoreTokens())
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		return st.nextToken();

	}

	int[] sort(int arr[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : arr)
			list.add(i);
		Collections.sort(list);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	char[] charsort(char arr[]) {
		ArrayList<Character> list = new ArrayList<>();
		for (char c : arr)
			list.add(c);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	long[] longsort(long arr[]) {
		ArrayList<Long> list = new ArrayList<Long>();
		for (long i : arr)
			list.add(i);
		Collections.sort(list);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public int[] readArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();
		return arr;
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public long[] longreadArray(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
}