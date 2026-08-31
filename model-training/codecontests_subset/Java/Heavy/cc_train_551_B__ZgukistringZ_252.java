
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public Main(MyScanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    public static void main(String[] args) {
    // write your code here
      MyScanner in = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      Main main = new Main(in,out);
      main.solve();
      out.close();
    }

    private void solve() {
      String a = in.next();
      String b = in.next();
      String c = in.next();
      int[] aCharactersCnt = new int[26];
      int[] bCharactersCnt = new int[26];
      int[] cCharactersCnt = new int[26];
      char[] character = new char[26];

      String[] chains = new String[] {a, b, c};
      int[][] charactersCnt = new int[][] {aCharactersCnt, bCharactersCnt, cCharactersCnt};

      for (int i = 0; i < 3 ; i++) {
          for (int j = 0; j < chains[i].length(); j ++) {
              charactersCnt[i][chains[i].charAt(j) - 'a']++;
          }
      }

      int max = 0;
      int maxB = 0;

      for (int cnt = 0; cnt < a.length() + 1; cnt++) {
        // try use cnt times b in a
        boolean isPossible = true;
        int maxC = 1000000;
        for (int i = 0; i < 26; i++) {
            if (aCharactersCnt[i] >= bCharactersCnt[i] * cnt) {
              if(cCharactersCnt[i] > 0) {
                  maxC = Math.min(maxC, (aCharactersCnt[i] - bCharactersCnt[i] * cnt) / cCharactersCnt[i]);
              }
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            break;
        }

        if (maxC + cnt > max) {
            max = maxC + cnt;
            maxB = cnt;
        }
        max = Math.max(max, maxC + cnt);
      }

      for (int i = 0; i < maxB; i++) {
        out.print(b);
      }
      int maxC = max - maxB;
      for (int i = 0; i < maxC; i++) {
        out.print(c);
      }

      for (int i = 0 ; i < 26; i++) {
          aCharactersCnt[i] -= (maxB * bCharactersCnt[i] + maxC * cCharactersCnt[i]);

          char current = (char)('a' + i);
          for (int j = 0; j < aCharactersCnt[i]; j++) {
              out.print(current);
          }
      }


    }

    // helpers

    private MyScanner in;
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
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

        String nextLine(){
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
