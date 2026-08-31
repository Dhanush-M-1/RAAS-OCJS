import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.*;


/**
 * gl hf
 */
public class Main {
    static class Task {
        PrintWriter out;



        public void solve(MyScanner in, PrintWriter out) {
            this.out = out;

            int n = in.nextInt();

            long d = in.nextInt();

            long[] originalValues = new long[n];
            long[] delta = new long[n];

            long currentValue = 0;

            for (int i = 0; i < n; i++) {
                delta[i] = in.nextInt();
                currentValue += delta[i];
                originalValues[i] = currentValue;
            }

            long[] maxValues = new long[n];
            maxValues[n - 1] = originalValues[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                maxValues[i] = Math.max(maxValues[i + 1], originalValues[i]);
            }

            /*
            printPretty("Delta: ", delta);
            printPretty("Original: ", originalValues);
            printPretty("Max:", maxValues);*/

            boolean error = false;
            int ans = 0;

            long currentDelta = 0;
            for (int i = 0; i < n; i++) {
                if (delta[i] == 0) {
                    //System.out.println("Current: " + currentDelta + ", original: " + originalValues[i] + " i = " + i);
                    if (currentDelta + originalValues[i] < 0) {
                        ans++;
                        //System.out.println("Max: " + maxValues[i]);

                        long maxPossible = d - (maxValues[i] + currentDelta);

                        currentDelta += maxPossible;
                        //System.out.println("Lift by " + maxPossible);
                        if (currentDelta + originalValues[i] > d || currentDelta + originalValues[i] < 0) {
                            error = true;
                        }
                    }
                } else {
                    if (currentDelta + originalValues[i] > d) {
                        error = true;
                    }
                }
            }

            if (error) {
                System.out.println("-1");
            } else {
                System.out.println(ans);
            }
        }

        private void printPretty(String name, long[] array) {
            System.out.println(String.format("%s", name));
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}