import java.io.*;
import java.util.Scanner;

public class Main {
    private static StreamTokenizer in;
    private static Scanner ins;
    private static PrintWriter out;


    public static void main(String[] args) {

        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            ins = new Scanner(System.in);
            out = new PrintWriter(System.out);
            try {
                if (System.getProperty("xDx") != null) {
                    in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
                    ins = new Scanner(new FileReader("input.txt"));
                    out = new PrintWriter(new FileWriter("output.txt"));
                }
            } catch (Exception e) {
                in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
                ins = new Scanner(System.in);
                out = new PrintWriter(System.out);
            }
            new Main().run(args);
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void run(String[] args) throws Exception {
        String a = nextString(), b = nextString(), c = nextString();
        int[] arrA = strToMask(a);
        int[] arrB = strToMask(b);
        int[] arrC = strToMask(c);

        int maxCountB = containsCount(arrB, arrA);

        int sum = maxCountB;
        int bCount = maxCountB;
        int cCount = 0;

        for (int i = 0; i <= maxCountB; i++) {
            int tmpCCount = containsCount(arrC, arrA);
            if (i + tmpCCount > sum) {
                sum = i + tmpCCount;
                bCount = i;
                cCount = tmpCCount;
            }
            if (i < maxCountB) {
                sub(arrA, arrB);
            }
        }

        arrA = strToMask(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bCount; i++) {
            sb.append(b);
            sub(arrA, arrB);
        }
        for (int i = 0; i < cCount; i++) {
            sb.append(c);
            sub(arrA, arrC);
        }
        for (int i = 0; i < 26; i++) {
            while (arrA[i] > 0) {
                arrA[i]--;
                sb.append((char) ('a' + i));
            }
        }
        out.print(sb.toString());
    }

    void sub(int[] big, int[] little) {
        for (int i = 0; i < 26; i++) {
            big[i] -= little[i];
        }
    }

    int[] strToMask(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }

        return res;
    }

    int containsCount(int[] included, int[] big) {
        int answ = 100_000;
        for (int i = 0; i < 26; i++) {
            if (included[i] == 0) {
                continue;
            }
            if (big[i] < included[i]) {
                return 0;
            }
            int tmp = big[i] / included[i];
            answ = Math.min(answ, tmp);
        }

        return answ;
    }

    private int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    private double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    private String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }

}
