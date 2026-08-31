//package com.amoghghadge.compProgramming.CodeforcesUnder1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PairProgramming {
    
    public static void main(String[] args) {
        
        FastReader in = new FastReader();
        StringBuffer sb = new StringBuffer();

        int t = in.nextInt();

        while (t > 0) {

            int k = in.nextInt(), n = in.nextInt(), m = in.nextInt();
            boolean failed = false;

            ArrayList<Integer> monocarp = new ArrayList<Integer>();
            ArrayList<Integer> polycarp = new ArrayList<Integer>();
            ArrayList<Integer> total = new ArrayList<Integer>();

            int i = 0, j = 0;

            for (int x = 0; x < n; x++) {

                monocarp.add(in.nextInt());
                
            }

            for (int x = 0; x < m; x++) {

                polycarp.add(in.nextInt());

            }

            for (int x = 0; x < (n + m); x++) {

                if (i < n && monocarp.get(i) == 0) {

                    k++;
                    i++;
                    total.add(0);
                    continue;

                } else if (j < m && polycarp.get(j) == 0) {

                    k++;
                    j++;
                    total.add(0);
                    continue;

                }/* else if (i < n && monocarp.get(i) <= k && j < m && polycarp.get(j) <= k) {

                    if (monocarp.get(i) <= polycarp.get(j)) {

                        total.add(monocarp.get(i));
                        i++;
                        continue;
                        
                    } else {

                        total.add(polycarp.get(j));
                        j++;
                        continue;

                    }

                }*/ else if (i < n && monocarp.get(i) <= k) {

                    total.add(monocarp.get(i));
                    i++;
                    continue;

                } else if (j < m && polycarp.get(j) <= k) {
                
                    total.add(polycarp.get(j));
                    j++;
                    continue;
                
                } else {

                    sb.append("-1\n");
                    failed = true;
                    break;

                }

            }

            if (!failed) {

                for (int x : total) {

                    sb.append(x + " ");
                    
                }

                sb.append("\n");

            }

            t--;

        }

        System.out.println(sb);

    }

    public static int search (int l, int r, int[] a, int key) {

        while (l <= r) {

            int middle = ((r - l) / 2) + l;

            if (a[middle] == key) {

                return middle;

            } else if (a[middle] < key) {

                l = middle + 1;

            } else {

                r = middle - 1;

            }

        }

        return -1;

    }

    public static void sort (int[] a) {

		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
        
	}

    public static void sort (long[] a) {

		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);

	}

    public static class FastReader {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public String next() {

            while (st == null || !st.hasMoreElements()) {

                try {

                    st = new StringTokenizer(br.readLine());

                } catch (IOException e) {

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

            String str = "";

            try {

                str = br.readLine();

            } catch (IOException e) {

                e.printStackTrace();

            }

            return str;

        }

        public int[] readArray(int n) {

			int[] a = new int[n];

			for (int i = 0; i < n; i++) {
                
                a[i] = nextInt();
			
            }

            return a;

		}

        public long[] readArrayLong(long n) {

			long[] a = new long[(int) n];

			for (int i = 0; i < n; i++) {
                
                a[i] = nextLong();
			
            }

            return a;

		}

    }

}
