//package codeforces.contest.c1421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
https://codeforces.com/problemset/problem/1421/B
 */
public class TaskB {

    static void solve() {
        int n = FS.nextInt();
        char[][] v = FS.read2ArrayChar(n, n);

        if (v[0][1] == '0' && v[1][0] == '0' && v[n - 1][n - 2] == '0' && v[n - 2][n - 1] == '0') {
            FS.pt.println(2);
            FS.pt.println('1' + " " + '2');
            FS.pt.println('2' + " " + '1');
        } else if (v[0][1] == '1' && v[1][0] == '1' && v[n - 1][n - 2] == '1' && v[n - 2][n - 1] == '1') {
            FS.pt.println(2);
            FS.pt.println('1' + " " + '2');
            FS.pt.println('2' + " " + '1');
        } else if (v[0][1] == '0' && v[1][0] == '0' && v[n - 1][n - 2] == '1' && v[n - 2][n - 1] == '1') {
            FS.pt.println("0");
        } else if (v[0][1] == '1' && v[1][0] == '1' && v[n - 1][n - 2] == '0' && v[n - 2][n - 1] == '0') {
            FS.pt.println("0");
        } else if (v[0][1] == v[1][0]) {
            FS.pt.println(1);
            if (v[n - 1][n - 2] == v[1][0]) {
                FS.pt.println(n + " " + (n - 1));
            } else {
                FS.pt.println((n - 1) + " " + n);
            }
        } else if (v[n - 1][n - 2] == v[n - 2][n - 1]) {
            FS.pt.println(1);
            if (v[n - 1][n - 2] == v[1][0]) {
                FS.pt.println("2 1");
            } else {
                FS.pt.println("1 2");
            }
        } else {
            FS.pt.println(2);
            if (v[1][0] != v[n - 2][n - 1]) {
                FS.pt.println("2 1");
                FS.pt.println((n - 1) + " " + n);
            } else {
                FS.pt.println("1 2");
                FS.pt.println((n - 1) + " " + n);
            }
        }
    }

    public static void main(String[] args) {
        int T = FS.nextInt();
        for (int tt = 0; tt < T; tt++) {
            solve();
        }
        FS.pt.close();
    }

    static class FS {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");
        static PrintWriter pt = new PrintWriter(System.out);

        static String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        static int[][] read2Array(int m, int n) {
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

        static char[][] read2ArrayChar(int m, int n) {
            char[][] a = new char[m][n];
            for (int i = 0; i < m; i++) {
                char[] tmp = next().toCharArray();
                for (int j = 0; j < tmp.length; j++) {
                    a[i][j] = tmp[j];
                }
            }
            return a;
        }

        static long[][] read2ArrayL(int m, int n) {
            long[][] a = new long[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

        void printArr(long[] arr) {
            for (long value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        static long[] readArrayL(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        static void printArr(int[] arr) {
            for (int value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        static void printArrL(int[] arr) {
            for (int value : arr) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        static void print2Arr(int[][] arr, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        static void print2Arr(long[][] arr, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        static void print2ArrChar(char[][] arr, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pt.print(arr[i][j]);
                    pt.print(" ");
                }
                pt.println();
            }
            pt.println();
        }

        static List<Long> readListLong(int n) {
            List<Long> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(nextLong());
            }
            return list;
        }

        static List<Integer> readListInt(int n) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(nextInt());
            }
            return list;
        }

        static <T> void printList(List<T> list) {
            for (T value : list) {
                pt.print(value);
                pt.print(" ");
            }
            pt.println();
        }

        static void close() {
            pt.close();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
