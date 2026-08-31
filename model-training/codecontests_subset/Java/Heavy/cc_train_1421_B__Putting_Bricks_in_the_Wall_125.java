import java.io.*;
import java.math.*;
import java.util.*;

// printArr() - prints the array
// intList, doubleList, longList
// nextIntArray

/* stuff you should look for
 * int overflow, array bounds
 * special cases (n=1?)
 * do smth instead of nothing and stay organized
 * WRITE STUFF DOWN
 */

public class current {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        // DO NOT FORGET TO REMOVE WHILE LOOP!!!!!!!!!!!!!!!
        // while (true) {
        int a = fr.nextInt();
        for (int i = 0; i < a; i++) {
            int n = fr.nextInt();
            char[][] arr = new char[n][n];
            for (int j = 0; j < n; j++) {
                arr[j] = fr.nextLine().toCharArray();
            }
            solve(arr);
        }
        // }
    }

    public static void solve(char[][] arr) {
        int l = arr.length;
        // b ->   0
        // a->  0
        // d ->   0
        // c -> 0
        char a = arr[1][0];
        char b = arr[0][1];
        char c = arr[l-1][l-2];
        char d = arr[l-2][l-1];
        // all same
        // 0 0 0 0
        if (c == d && a == b && c == a) {
            System.out.println(2);
            System.out.println((l-1) + " " + l);
            System.out.println(l + " " + (l-1));
        } else if (c == d && a == b) {
            // 0 0 1 1
            System.out.println(0);
        } else if (c == d || a == b) {
            // 0 1 0 0 etc
            char[] e = {a, b, c, d};
            int[] count = new int[2];
            for (char i : e) {
                if (i == '1') {
                    count[1]++;
                } else {
                    count[0]++;
                }
            }
            System.out.println(1);
            int min = Math.min(count[0], count[1]);
            char charmin = '1';
            if (min == count[0]) {
                charmin = '0';
            }
            int j = l-1;
            if (charmin == a) {
                System.out.println(1 + " " + 2);
            } else if (charmin == b) {
                System.out.println(2 + " " + 1);
            } else if (charmin == c) {
                System.out.println(j + " " + l);
            } else if (charmin == d) {
                System.out.println(l + " " + j);
            }
        } else {
            // 0 1 0 1 we still need to find a sol for
            System.out.println(2);
            // a b c d
            // 0 1 0 1
            // 1 0 1 0
            if (a == c) {
                // b & c need to cahnge
                System.out.println(1 + " " + 2);
                System.out.println(l + " " + (l-1));
            } else if (a == d) {
                // a b c d
                // 0 1 1 0
                // 1 0 0 1
                // b & d need to change
                System.out.println(1 + " " + 2);
                System.out.println((l-1) + " " + l);
            }
        }
    }

    public static Set<Integer> get(List<Set<Integer>> graph, int i) {
        try {
            return graph.get(i);
        } catch (IndexOutOfBoundsException e) {
            return new HashSet<>();
        }
    }

    public static void printArr(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static int[] bfs(List<Set<Integer>> graph, int v) {
        int l = graph.size();
        Deque<Integer> list = new ArrayDeque<>();
        list.add(v);
        boolean[] seen = new boolean[l];
        int distance = 0;
        int node = v;
        int size = 1;
        int index = 0;
        // Iterate over every single vertice and edge
        // O(V+E) -> O(V) for trees
        while (!list.isEmpty()) {
            int cur = list.poll();
            seen[cur] = true;
            node = cur;

            index++;
            if (index > size) {
                distance++;
                size = list.size();
                index = 0;
            }

            for (int i : graph.get(cur)) {
                if (!seen[i]) {
                    seen[i] = true;
                    list.add(i);
                }
            }
        }
        return new int[]{node, distance};
    }

    static class SegTree {
        int startIndex, endIndex;
        long sum;
        SegTree lchild, rchild;

        SegTree(int[] arr) {this(0, arr.length-1, arr);}

        SegTree(int startIndex, int endIndex, int[] arr) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            if (startIndex == endIndex) sum = arr[startIndex];
            else {
                int mid = (startIndex + endIndex) / 2;
                lchild = new SegTree(startIndex, mid, arr);
                rchild = new SegTree(mid + 1, endIndex, arr);
                sum = lchild.sum + rchild.sum;
                recalc();
            }
        }

        void recalc() {
            if (startIndex == endIndex) return; sum = lchild.sum + rchild.sum;
        }

        public void valueUpdate(int index, int value) {
            if (startIndex == endIndex) {sum = value; return;}
            if (index > lchild.endIndex) rchild.valueUpdate(index, value); else lchild.valueUpdate(index, value); recalc();
        }

        public long rangeSum(int startIndex, int endIndex) {
            if (endIndex < this.startIndex || startIndex > this.endIndex) return 0;
            if (startIndex <= this.startIndex && endIndex >= this.endIndex) return sum;
            return lchild.rangeSum(startIndex, endIndex) + rchild.rangeSum(startIndex, endIndex);
        }
    }

    public static double sum(List<Long> n) {
        double a = 0;
        for (long i : n) {
            a += i;
        }
        return a;
    }

    public static int toInt(String n) {
        return Integer.parseInt(n);
    }

    public static double toDouble(String n) {
        return Double.parseDouble(n);
    }

    public static long toLong(String n) {
        return Long.parseLong(n);
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String a = "";
            try {
                a = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return a;
        }

        int[] nextIntArray() {
            return intArray(nextLine().split(" "));
        }

        long[] nextLongArray() {
            return longArray(nextLine().split(" "));
        }

        double[] nextDoubleArray() {
            return doubleArray(nextLine().split(" "));
        }

        public int getInt(int index) {
            String[] arr = nextLine().split(" ");
            return Integer.parseInt(arr[index]);
        }

        public long getLong(int index) {
            String[] arr = nextLine().split(" ");
            return Long.parseLong(arr[index]);
        }

        public double getDouble(int index) {
            String[] arr = nextLine().split(" ");
            return Double.parseDouble(arr[index]);
        }

        public List<String> stringList() {
            String[] arr = nextLine().split(" ");
            return Arrays.asList(arr);
        }

        public List<Integer> intList() {
            String[] arr = nextLine().split(" ");
            List<Integer> a = new ArrayList<>();
            for (String i : arr) {
                a.add(Integer.parseInt(i));
            }
            return a;
        }

        public List<Double> doubleList() {
            String[] arr = nextLine().split(" ");
            List<Double> a = new ArrayList<>();
            for (String i : arr) {
                a.add(Double.parseDouble(i));
            }
            return a;
        }

        public List<Long> longList() {
            String[] arr = nextLine().split(" ");
            List<Long> a = new ArrayList<>();
            for (String i : arr) {
                a.add(Long.parseLong(i));
            }
            return a;
        }
    }


    public static int[] intArray(String[] arr) {
        int l = arr.length;
        int[] a = new int[l];
        for (int i = 0; i < l; i++) {
            a[i] = Integer.parseInt(arr[i]);
        }
        return a;
    }

    public static long[] longArray(String[] arr) {
        int l = arr.length;
        long[] a = new long[l];
        for (int i = 0; i < l; i++) {
            a[i] = Long.parseLong(arr[i]);
        }
        return a;
    }

    public static double[] doubleArray(String[] arr) {
        int l = arr.length;
        double[] a = new double[l];
        for (int i = 0; i < l; i++) {
            a[i] = Double.parseDouble(arr[i]);
        }
        return a;
    }
}