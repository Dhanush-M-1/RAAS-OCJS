import java.io.PrintWriter;
import java.util.*;

public class CF1261D1 {

    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] seq = new int[n];
        for (int t = 0; t < n; t++) {
            seq[t] = in.nextInt();
        }
        int reqs = in.nextInt();
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int l : seq) {
            sorted.add(l);
        }
        sorted.sort(Collections.reverseOrder());
        // System.out.println(sorted.toString());
        for (int req = 0; req < reqs; req++) {
            int k = in.nextInt();
            int pos = in.nextInt();

            ArrayList<Integer> subSeqInds = new ArrayList<>();
            boolean[] used = new boolean[n];
            for (int i = k - 1; i >= 0; i--) {
                int currEl = sorted.get(i);
                for (int a = 0; a < n; a++) {
                    if (seq[a] == currEl && !used[a]) {
                        used[a] = true;
                        subSeqInds.add(a);
                        // System.out.println("a: " + a);
                        break;
                    }
                }
            }
            Collections.sort(subSeqInds);
            out.println(seq[subSeqInds.get(pos - 1)]);
        }
    }

    public static void main(String[] args) {
        new CF1261D1().run();
    }

    public void run() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}