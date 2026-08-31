//package CodeForces.C731.Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) {
        int t = in.NI();
        while(t-->0) {
            int k = in.NI(); int n = in.NI(); int m = in.NI();
            int[] ar = new int[n];
            for (int i=0;i<n;i++) ar[i]= in.NI();
            int[] br = new int[m];
            for (int i=0;i<m;i++) br[i] = in.NI();

            List<Integer> ans = new ArrayList<>();
            int p1 = 0; int p2 = 0;
            int zc = 0; int mm = 0;
            while (p1<n && p2<m) {
                //out.printf("%d %d\n", p1, p2); out.flush();
                if (ar[p1] == 0) { ans.add(0); p1++; zc++;}
                else if (br[p2] == 0) {ans.add(0); p2++; zc++;}
                else {
                    if (ar[p1] < br[p2]) {
                        if (ar[p1] > k + zc) {
                            out.println(-1);
                            mm=1;break;
                        } else {
                            ans.add(ar[p1]); p1++;
                        }
                    } else {
                        if (br[p2] > k + zc) {
                            out.println(-1);
                            mm=1; break;
                        } else {
                            ans.add(br[p2]); p2++;
                        }
                    }
                }
            }

            while(p1<n && mm ==0) {
                //out.printf("%d\n", p1); out.flush();
                if (ar[p1]==0) {ans.add(0); zc++; p1++;}
                else {
                    if (ar[p1] > k+zc) {
                        out.println(-1); mm =1; break;
                    } else {
                        ans.add(ar[p1]); p1++;
                    }
                }
            }

            while(p2<m && mm ==0) {
                //out.printf("%d\n", p2); out.flush();
                if (br[p2]==0) {ans.add(0); p2++; zc++;}
                else {
                    if (br[p2] > k+zc) {
                        out.println(-1); mm = 1; break;
                    } else {
                        ans.add(br[p2]); p2++;
                    }
                }
            }

            if (mm==0) {
                for (int i=0;i<n+m;i++) {
                    out.printf("%d ", ans.get(i));
                }
                out.println();
            }

            out.flush();
        }
        out.close();
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NI() {
            return Integer.parseInt(next());
        }

        public long NL() {
            return Long.parseLong(next());
        }

    }
}