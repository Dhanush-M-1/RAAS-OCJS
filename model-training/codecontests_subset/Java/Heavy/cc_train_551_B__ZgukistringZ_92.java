import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Y {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String a = scanner.next();
        String b = scanner.next();
        String c = scanner.next();
        int[] freqA = new int[26];
        for (int i = 0; i < a.length(); i++) {
            freqA[a.charAt(i) - 'a']++;
        }
        int[] freqB = new int[26];
        for (int i = 0; i < b.length(); i++) {
            freqB[b.charAt(i) - 'a']++;
        }
        int[] freqC = new int[26];
        for (int i = 0; i < c.length(); i++) {
            freqC[c.charAt(i) - 'a']++;
        }
        int maxB = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freqB[i] != 0)
                maxB = Math.min(maxB, freqA[i] / freqB[i]);
        }
        int max = 0;
        int countB = 0;
        int countC = 0;
        for (int i = 0; i <= maxB; i++) {
            int maxC = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (freqC[j] != 0)
                    maxC = Math.min(maxC, (freqA[j] - i * freqB[j]) / freqC[j]);
            }
            if(maxC + i > max){
                max = maxC + i;
                countB = i;
                countC = maxC;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int count = freqA[i] - freqB[i] * countB - freqC[i] * countC;
            for (int j = 0; j < count; j++) {
                char x = ((char)(i + 'a'));
                out.append(x);
            }
        }
        while (countB > 0){
            out.append(b);
            countB--;
        }
        while (countC > 0) {
            out.append(c);
            countC--;
        }
        System.out.println(out);
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}