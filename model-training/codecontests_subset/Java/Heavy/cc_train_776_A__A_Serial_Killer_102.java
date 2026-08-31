import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static final Random random = new Random();
	static PrintWriter out = new PrintWriter((System.out));
	static Reader sc = new Reader();

	public static void main(String args[]) throws IOException {
//		int t = sc.nextInt();
//		while (t-- > 0) {
////        	CODE START FROM HERE 
	    String fir = sc.next();
	    String sec = sc.next();
		int  n  = sc.nextInt();

	    String arr[]  = new String[n*2];
	    for(int i = 0;i<n*2;i++)
	    {
	    	arr[i] = sc.next();
	    }
	    Set<String> hs =  new TreeSet<>();
	    hs.add(fir);
	    hs.add(sec);
	    for (String s : hs) 
            System.out.print(s + " "); 
	    System.out.println();
	    for(int i =0;i<n*2;i++)
	    {
	    	if(hs.contains(arr[i]))
	    		hs.remove(arr[i]);
	    	else
	    		hs.add(arr[i]);
	    	if(hs.size()==2)
	    	{
	    		 for (String s : hs)		 
	    	            System.out.print(s + " "); 
	    		 System.out.println();
	    	}
	    		
	    }
//		}
	}

// Fast Input Output
	static class Reader {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		public String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String nextLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public boolean hasNext() {
			String next = null;
			try {
				next = br.readLine();
			} catch (Exception e) {
			}
			if (next == null) {
				return false;
			}
			st = new StringTokenizer(next);
			return true;
		}

	}

	// EFFICIENT SORTING Ascending
	static void ruffleSortAsc(Integer[] a) {
		int n = a.length; // shuffle, then sort
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}

//	EFFICIENT SORTING Descending
	static void ruffleSortDesc(Integer[] a) {
		int n = a.length; // shuffle, then sort
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a, Collections.reverseOrder());
	}

	// Array Sum
	static long sum(Integer[] arr) {
		long sum = 0;
		for (int i : arr)
			sum += i;
		return sum;
	}

	// ArrayList Sum
	static long sumal(ArrayList<Integer> al) {
		long sum = 0;
		for (int i : al)
			sum += i;
		return sum;
	}

	// swap array elements
	static void swap(int arr1[], int arr2[], int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}

	// reading array value;
	static void read(Integer[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		return;
	}

//    reading arraylistValue

	static void readal(ArrayList<Integer> al, int n) {
		for (int i = 0; i < n; i++)
			al.add(sc.nextInt());
		return;
	}

	// check for even odd
	static boolean isEven(long n) {
		return ((n & 1) != 1);
	}

	// max in a array
	static int max(Integer[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
			if (max < arr[i])
				max = arr[i];
		return max;
	}

//  print array
	static void printarr(Integer arr[]) {
		for (int i : arr)
			System.out.println(i);
	}

// ceil of two elements
	static int ceil(int a, int b) {
		return (int) Math.ceil(((double) a / (double) b));
	}

// floor of two elements
	static long floor(int a, int b) {
		return (long) Math.floor(((double) a / (double) b));
	}
}