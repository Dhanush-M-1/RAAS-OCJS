/**
 * Created on 6/8/14
 *
 * @author: Anirudh Rayabharam <anirudh.rayabharam@gmail.com>
 * @handle: code_overlord
 */
import java.io.*;

public class KitaharaHarukiGift {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintStream out = System.out;

        int n = in.nextInt();
        int[] w = new int[n];

        int sum = 0;
        int oneH, twoH;
        oneH = twoH = 0;
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            sum += w[i];
            if (w[i] == 100) oneH++;
            else twoH++;
        }

        int each = sum / 2;
        int x = sum / 100;

        if (x % 2 == 1) out.println("NO");
        else {
            boolean possible = false;
            for (int i = 0; i <= twoH; i++) {
                if (200 * i <= each && each - 200 * i <= oneH * 100) possible = true;
            }

            if (possible) out.println("YES");
            else out.println("NO");
        }
    }

    private static class InputReader {
        public BufferedReader reader;
        private int tokenCount, nextTokenIndex;
        private String[] tokens;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenCount = nextTokenIndex = 0;
        }

        public String next() {
            String nextLine;
            if (nextTokenIndex == tokenCount) {
                try {
                    nextLine = reader.readLine();
                    nextTokenIndex = 0;
                    tokens = nextLine.split("\\s");
                    tokenCount = tokens.length;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokens[nextTokenIndex++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
