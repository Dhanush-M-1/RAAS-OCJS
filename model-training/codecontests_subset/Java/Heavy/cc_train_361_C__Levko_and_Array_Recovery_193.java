
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ZadC {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Op> ops = new ArrayList<>();
        int[] nn = new int[n];
        int[] nnt = new int[n];
        boolean[] filed = new boolean[n];

        for (int i = 0; i < m; i++) {
            Op o = new Op();
            o.op = sc.nextInt();
            o.a = sc.nextInt();
            o.b = sc.nextInt();
            o.v = sc.nextInt();
            ops.add(o);
        }

        
        for (int j=ops.size()-1; j>=0; j--){
            Op op = ops.get(j);
            for (int i = op.a - 1; i < op.b; i++) {
                if (op.op == 1) {
                    if (filed[i]) {
                        nn[i] -= op.v;
                    }
                } else {
                    if (!filed[i]) {
                        filed[i] = true;
                        nn[i] = op.v;
                    } else {
                        if (nn[i] > op.v) {
                            nn[i] = op.v;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!filed[i]) {
                nn[i] = 0;
            }
            nnt[i] = nn[i];
        }

        boolean good = true;

        for (Op op : ops) {
            if (op.op == 1) {
                for (int i = op.a - 1; i < op.b; i++) {
                    nnt[i] += op.v;
                }
            } else {
                int max = nnt[op.a - 1];
                for (int i = op.a; i < op.b; i++) {
                    max = (max < nnt[i]) ? nnt[i] : max;
                }
                if (max < op.v) {
                    good = false;
                    break;
                }
            }
        }

        if (!good) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                System.out.print(nn[i] + " ");
            }
        }


    }

    static class Op {

        int op;
        int a;
        int b;
        int v;

        public Op() {
        }

        public Op(int op, int a, int b, int v) {
            this.op = op;
            this.a = a;
            this.b = b;
            this.v = v;
        }
    }

    static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            String next = next();
            return Integer.parseInt(next);
        }
    }
}
