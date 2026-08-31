import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Purpose:
 * Created by Huynh Quang Thao on 6/12/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.run();
    }

    public void run() throws Exception {
        Scanner sc = null;
        PrintWriter pr = null;

        pr=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //sc = new Scanner(new File("input.txt"));

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        int[] ma = buildMap(a);
        int[] mb = buildMap(b);
        int[] mc = buildMap(c);

        int maximum_b = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (mb[i] == 0) continue;
            maximum_b = Math.min(maximum_b, ma[i] / mb[i]);
        }
        if (maximum_b == Integer.MAX_VALUE) maximum_b = 0;
       // System.out.println("maximum b: " + maximum_b);

        // brute force
        // test all case for b string
        int final_b = 0;
        int final_c = 0;
        int max = 0;
        for (int count_b = 0; count_b <= maximum_b; count_b++) {
            int[] ta = new int[26];
            // find remain chars in a
            boolean isExist = true;
            for (int j = 0; j < 26; j++) {
                ta[j] = ma[j] - count_b * mb[j];
                if (ta[j] < 0) isExist = false;
            }

            // remove this case from calculation
            if (!isExist) continue;

            // find how many string c can be fixed
            int count_c = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (ta[j] < 0) continue; // not exist this case
                if (mc[j] == 0) continue;
                count_c  = Math.min(count_c, ta[j] / mc[j]);
            }
            //System.out.println("count b: " + count_b);
           // System.out.println("count c: " + count_c);
            if (count_b + count_c > max) {
                max = count_b + count_c;
                final_b = count_b;
                final_c = count_c;
            }
        }

        //System.out.println("max:" + max);

        String res = buildString(ma, mb, mc, b, c, final_b, final_c);
        pr.print(res);


        pr.close();
        sc.close();
    }

    private String buildString(int[] ma, int[] mb, int[] mc, String b, String c, int count_b, int count_c) {
        StringBuilder sb = new StringBuilder();
        // build string
        for (int i = 0; i < count_b; i++) {
            sb.append(b);
        }
        for (int i = 0; i < count_c; i++) {
            sb.append(c);
        }
        // find remain
        for (int i = 0; i < 26; i++) {
            ma[i] = ma[i] - mb[i]*count_b - mc[i]*count_c;
        }
        // append again to string
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < ma[i]; j++) {
                sb.append((char)(i + 97));
            }
        }
        return sb.toString();
    }



   private int[] buildMap(String a) {
       int[] stat = new int[26];
       for (int i = 0; i < a.length(); i++) {
           stat[a.charAt(i) - 97]++;
       }
       return stat;
   }

    static class InputReader {
        public BufferedReader reader;

        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

    }
}
