import java.util.*;
import java.io.*;

public class test {

    static long mod = 1000000007;
    static long inf = Long.MAX_VALUE;

    public static void solve(int k, int n, int m, long[] a, long[] b) {
        int ia = 0;
        int ib = 0;
        int iterations  = n + m;
        ArrayList<Long> ans = new ArrayList<>();
        while((ia < n || ib < m) && iterations > 0) {
            iterations--;
            if(ia < n) {
                if(a[ia] == 0) {
                    ans.add(a[ia]);
                    k += 1;
                    ia += 1;
                }
                else if(a[ia] <= k) {
                    ans.add(a[ia]);
                    ia += 1;
                }
            }
            if(ib < m) {
                if(b[ib] == 0) {
                    ans.add(b[ib]);
                    k += 1; 
                    ib += 1;
                }
                else if(b[ib] <= k) {
                    ans.add(b[ib]);
                    ib += 1;
                }
            }
        }
        if(ans.size() != n + m) {
            System.out.println(-1);
            return;
        }
        for(Long i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
/**
5

3 2 2
2 0
0 5

4 3 2
2 0 5
0 6

0 2 2
1 0
2 3

5 4 4
6 0 8 0
0 7 0 9

5 4 1
8 7 8 0
0


2 0 0 5 
0 2 0 6 5 
-1
0 6 0 7 0 8 0 9
-1

 */

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            String temp = sc.nextLine();
            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] a = sc.readArray(n);
            long[] b = sc.readArray(m);
            // solve
            solve(k, n, m, a, b);
        }
    }

     
	public static void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

    public static int maxIndex(long[] arr) {
        long max = Long.MIN_VALUE;
        int index = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }
        return index;
    }

    public static int minIndex(long[] arr) {
        long min = Long.MAX_VALUE;
        int index = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] < min) {
                index = i;
                min = arr[i];
            }
        }
        return index;
    }

    public static void debugArray(long[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    } 

    public static void debugArrayList(ArrayList<Long> arr) {
        for(Long i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
 
    public static long LCM(long a, long b) {
        return Math.abs(a*b) / gcd(a, b);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st=new StringTokenizer(br.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str="";
            try {
                str=br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for(int i = 0; i < n ; i++) {
                a[i] = nextLong();
            }
            return a;
        }
    }
}