import static java.lang.Math.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class cf1 {
	static FastReader x = new FastReader();
	static OutputStream outputStream = System.out;
	static PrintWriter out = new PrintWriter(outputStream);

	/*---------------------------------------CODE STARTS HERE-------------------------*/
	public static void main(String[] args) {

		int t = x.nextInt();
		StringBuilder str = new StringBuilder();
		while (t > 0) {
			int k = x.nextInt();
			int n = x.nextInt();
			int m = x.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for(int i=0;i<n;i++) {
				a[i]= x.nextInt();
			}
			for(int i=0;i<m;i++) {
				b[i]= x.nextInt();
			}
			int f=0,s=0;
			ArrayList<Integer> arr = new ArrayList<>();
			boolean done =true;
			while(done&&f<n&&s<m) {
				if(a[f]==0) {
					arr.add(a[f]);
					k++;
					f++;
					
				}else if(a[f]<=k) {
					arr.add(a[f]);
					f++;
					
				}
				else if(b[s]==0) {
					arr.add(b[s]);
					k++;
					s++;
					
				}else if(b[s]<=k) {
					arr.add(b[s]);
					s++;
					
				}else {
					done = false;
				}
			}
			while(done&&f<n) {
				if(a[f]==0) {
					arr.add(a[f]);
					k++;
					f++;
					
				}else if(a[f]<=k){
					arr.add(a[f]);
					f++;
					
				}else {
					done = false;
				}
			}
			while(done&&s<m) {
				if(b[s]==0) {
					arr.add(b[s]);
					k++;
					s++;
				}else if(b[s]<=k){
					arr.add(b[s]);
					s++;
					
				}else {
					done = false;
				}
			}
			if(done) {
				for(int i=0;i<arr.size();i++) {
					if(i!=arr.size()-1)
						System.out.print(arr.get(i)+" ");
					else {
						System.out.println(arr.get(i));
					}
				}
			}else {
				System.out.println(-1);
			}
			str.append("\n");
			t--;
		}
		out.println(str);
		out.flush();
	}

	/*--------------------------------------------FAST I/O--------------------------------*/
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

		char nextchar() {
			char ch = ' ';
			try {
				ch = (char) br.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ch;
		}
	}

	/*--------------------------------------------BOILER PLATE---------------------------*/
	static int[] readarr(int n) {
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = x.nextInt();
		}
		return arr;
	}

	static int[] sortint(int a[]) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i : a) {
			al.add(i);
		}
		Collections.sort(al);
		for (int i = 0; i < a.length; i++) {
			a[i] = al.get(i);
		}
		return a;
	}

	static long[] sortlong(long a[]) {
		ArrayList<Long> al = new ArrayList<>();
		for (long i : a) {
			al.add(i);
		}
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			a[i] = al.get(i);
		}
		return a;
	}

	static int pow(int x, int y) {
		int result = 1;
		while (y > 0) {
			if (y % 2 == 0) {
				x = x * x;
				y = y / 2;
			} else {
				result = result * x;
				y = y - 1;
			}
		}
		return result;
	}

	static int[] revsort(int a[]) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i : a) {
			al.add(i);
		}
		Collections.sort(al, Comparator.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			a[i] = al.get(i);
		}
		return a;
	}

	static int[] gcd(int a, int b, int ar[]) {
		if (b == 0) {
			ar[0] = a;
			ar[1] = 1;
			ar[2] = 0;
			return ar;
		}
		ar = gcd(b, a % b, ar);
		int t = ar[1];
		ar[1] = ar[2];
		ar[2] = t - (a / b) * ar[2];
		return ar;
	}

	static boolean[] esieve(int n) {
		boolean p[] = new boolean[n + 1];
		Arrays.fill(p, true);
		for (int i = 2; i * i <= n; i++) {
			if (p[i] == true) {
				for (int j = i * i; j <= n; j += i) {
					p[j] = false;
				}
			}
		}
		return p;
	}

	static ArrayList<Integer> primes(int n) {
		boolean p[] = new boolean[n + 1];
		ArrayList<Integer> al = new ArrayList<>();
		Arrays.fill(p, true);
		int i = 0;
		for (i = 2; i * i <= n; i++) {
			if (p[i] == true) {
				al.add(i);
				for (int j = i * i; j <= n; j += i) {
					p[j] = false;
				}
			}
		}
		for (i = i; i <= n; i++) {
			if (p[i] == true) {
				al.add(i);
			}
		}
		return al;
	}

	static int etf(int n) {
		int res = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				res /= i;
				res *= (i - 1);
				while (n % i == 0) {
					n /= i;
				}
			}
		}
		if (n > 1) {
			res /= n;
			res *= (n - 1);
		}
		return res;
	}

	static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}