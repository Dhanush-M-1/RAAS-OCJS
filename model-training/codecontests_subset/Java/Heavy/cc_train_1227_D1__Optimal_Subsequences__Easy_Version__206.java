import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int x, i;
        public Pair (int x, int i) {
            this.x = x;
            this.i = i;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.x != o.x) return o.x - this.x;
            return this.i - o.i;
        }
    }

    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(new File("input.txt"));
//        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) a[i] = new Pair(scan.nextInt(), i);
        Arrays.sort(a);
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int k = scan.nextInt();
            int pos = scan.nextInt();
            ArrayList<Integer> now = new ArrayList<>();
            for (int j = 0; j < k; j++) now.add(a[j].i);
            Collections.sort(now);
            for (int j = 0; j < k; j++) {
                if (now.get(pos - 1) == a[j].i) {
                    System.out.println(a[j].x);
                    break;
                }
            }
        }
    }
}