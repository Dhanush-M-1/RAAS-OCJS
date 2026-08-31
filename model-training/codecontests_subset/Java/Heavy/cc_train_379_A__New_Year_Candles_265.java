import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static sun.swing.MenuItemLayoutHelper.max;

public class Main {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {

        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Main().run();
        // Sworn to fight and die
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    static int curr = 0;
    static long ans = 0;

    private static void mergeSort(int[] a, int levtIndex, int rightIndex) {
        final int MAGIC_VALUE = 2;
        if (levtIndex < rightIndex) {
            if (rightIndex - levtIndex <= MAGIC_VALUE) {
                insertionSort(a, levtIndex, rightIndex);
            } else {
                int middleIndex = (levtIndex + rightIndex) / 2;
                mergeSort(a, levtIndex, middleIndex);
                ans += curr;
                mergeSort(a, middleIndex + 1, rightIndex);
                ans += curr;
                merge(a, levtIndex, middleIndex, rightIndex);
                ans += curr;
            }
        }
    }

    private static void merge(int[] a, int levtIndex, int middleIndex,
                              int rightIndex) {
        curr = 0;
        int length1 = middleIndex - levtIndex + 1;
        int length2 = rightIndex - middleIndex;
        int[] levtArray = new int[length1];
        int[] rightArray = new int[length2];
        System.arraycopy(a, levtIndex, levtArray, 0, length1);
        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
        for (int k = levtIndex, i = 0, j = 0; k <= rightIndex; k++) {
            if (i == length1) {
                a[k] = rightArray[j++];
            } else if (j == length2) {
                a[k] = levtArray[i++];
            } else {
                if (levtArray[i] > rightArray[j]) curr += middleIndex - i + 1;
                a[k] = levtArray[i] <= rightArray[j] ? levtArray[i++]
                        : rightArray[j++];
            }
        }
    }

    private static void insertionSort(int[] a, int levtIndex, int rightIndex) {
        for (int i = levtIndex + 1; i <= rightIndex; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= levtIndex && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    class LOL implements Comparable<LOL> {

        int x;
        int y;

        public LOL(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public boolean equals(Object object) {
            boolean sameSame = false;

            if (object != null && object instanceof LOL) {
                sameSame = ((this.x == ((LOL) object).x) && (this.y == ((LOL) object).y));
            }

            return sameSame;
        }

        @Override
        public int compareTo(LOL o) {

            return (x - o.x); // ---->
            // return o.x * o.y - x * y; // <----
        }

    }

    long[][] game;
    int n;
    long score;
    boolean isMerge[][];

    void move(String s) {
        if(s.equals("L")) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (game[i][j] != 0) {
                        long a = game[i][j];
                        game[i][j] = 0;
                        int ind = j;

                        while (ind >= 0 && game[i][ind] == 0) ind--;

                        if (ind >= 0 && game[i][ind] == a && !isMerge[i][ind]) {
                            game[i][ind] = 2 * a;
                            score += 2 * a;
                            isMerge[i][ind] = true;
                        } else game[i][ind + 1] = a;
                    }
                }
        }
        if(s.equals("R")) {
            for (int i = 0; i < n; i++)
                for (int j = n - 1; j >= 0; j--) {
                    if (game[i][j] != 0) {
                        long a = game[i][j];
                        game[i][j] = 0;
                        int ind = j;

                        while (ind < n && game[i][ind] == 0) ind++;

                        if (ind < n && game[i][ind] == a && !isMerge[i][ind]) {
                            game[i][ind] = 2 * a;
                            score += 2 * a;
                            isMerge[i][ind] = true;
                        } else game[i][ind - 1] = a;
                    }
                }
        }
        if (s.equals("U")) {
            for (int i = n - 1; i >= 0; i--)
                for (int j = 0; j < n; j++) {
                    if (game[i][j] != 0) {
                        long a = game[i][j];
                        game[i][j] = 0;
                        int ind = i;

                        while (ind >= 0 && game[ind][j] == 0) ind--;

                        if (ind >= 0 && game[ind][j] == a && !isMerge[ind][j]) {
                            game[ind][j] = 2 * a;
                            score += 2 * a;
                            isMerge[ind][j] = true;
                        } else game[ind + 1][j] = a;
                    }
                }
        }
        if (s.equals("D")) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (game[i][j] != 0) {
                        long a = game[i][j];
                        game[i][j] = 0;
                        int ind = i;

                        while (ind < n && game[ind][j] == 0) ind++;

                        if (ind < n && game[ind][j] == a && !isMerge[ind][j]) {
                            game[ind][j] = 2 * a;
                            score += 2 * a;
                            isMerge[ind][j] = true;
                        } else game[ind - 1][j] = a;
                    }
                }
        }

    }




    public void solve() throws IOException {
        int a = readInt();
        int b = readInt();
        int ost = a;
        int ans = a;
        while (ost >= b) {
            ans += (ost/b);
            ost = (ost/b) + (ost % b);
        }
        out.print(ans);

    }
}