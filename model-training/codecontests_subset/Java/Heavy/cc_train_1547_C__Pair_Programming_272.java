

import java.io.*;
import java.util.*;

public class Main {

    /************************ SOLUTION STARTS HERE ************************/
    private static void solve() {
        int t = nextInt();
        while(t-- > 0) {
            int k = nextInt();
            int n = nextInt();
            int m = nextInt();

            int[] a = nextIntArray(n);
            int[] b = nextIntArray(m);

            int[] r = new int[n+m];
            int i = 0;
            int j = 0;
            int l = 0;
            boolean can = true;
            while(i < n && j < m) {
                if(a[i] == 0) {
                    r[l++] = a[i++];
                    k++;
                } else if(b[j] == 0) {
                    r[l++] = b[j++];
                    k++;
                } else {
                    int min = Math.min(a[i], b[j]);
                    if(min > k) {
                        can = false;
                        break;
                    }
                    if(a[i] < b[j]) {
                        r[l++] = a[i++];
                    } else {
                        r[l++] = b[j++];
                    }
                }
            }

            while(i < n) {
                if(a[i] == 0) {
                    r[l++] = a[i++];
                    k++;
                } else {
                    if(a[i] > k) {
                        can = false;
                        break;
                    } else {
                        r[l++] = a[i++];
                    }
                }
            }

            while(j < m) {
                if(b[j] == 0) {
                    r[l++] = b[j++];
                    k++;
                } else {
                    if(b[j] > k) {
                        can = false;
                        break;
                    } else {
                        r[l++] = b[j++];
                    }
                }
            }

            if(!can) {
                println(-1);
            } else {
                for(int p =0;p<r.length;p++) {
                    print(r[p] + (p == r.length-1 ? "" : " "));
                }
                println("");
            }
        }
    }

    /************************ SOLUTION ENDS HERE ************************/



    /************************ TEMPLATE STARTS HERE **********************/

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false);
        st = null;
        solve();
        reader.close();
        writer.close();
    }

    static BufferedReader  reader;
    static PrintWriter     writer;
    static StringTokenizer st;

    static String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return st.nextToken();
    }

    static String nextLine() {
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static char nextChar() {
        return next().charAt(0);
    }

    static int[] nextIntArray(int n) {
        int[] a = new int[n];
        int i = 0;
        while (i < n) {
            a[i++] = nextInt();
        }
        return a;
    }

    static long[] nextLongArray(int n) {
        long[] a = new long[n];
        int i = 0;
        while (i < n) {
            a[i++] = nextLong();
        }
        return a;
    }

    static int[] nextIntArrayOneBased(int n) {
        int[] a = new int[n + 1];
        int i = 1;
        while (i <= n) {
            a[i++] = nextInt();
        }
        return a;
    }

    static long[] nextLongArrayOneBased(int n) {
        long[] a = new long[n + 1];
        int i = 1;
        while (i <= n) {
            a[i++] = nextLong();
        }
        return a;
    }

    static void print(Object o) {
        writer.print(o);
    }

    static void println(Object o) {
        writer.println(o);
    }

    static void printArr(int[] arr) {
        for(int i = 0 ; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /************************ TEMPLATE ENDS HERE ************************/
}
