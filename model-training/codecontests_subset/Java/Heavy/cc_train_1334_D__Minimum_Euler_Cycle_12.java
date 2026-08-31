import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @link: https://codeforces.com/contest/1334/problem/D
 * @Idea: the minimum lexicographical cycle will be in formed:
 * 1. (1-2)-(1-3)-(1-4)....-(1-n); (2 * (n - 1))
 * 2. (2-3)-(2-4)-(2-5)....-(2-n); (2 * (n - 2))
 * 3. ...........................; 2 * (n - 1);
 * n. 1
 */
public class MinimumEulerCycle {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int test = 0; test < t; test++){
                int n = in.nextInt();
                long l = in.nextLong();
                long r = in.nextLong();
                int row = 0;
                long total = 0;
                for  (row = 1; row <= n - 1; row++){
                    total += 2 * (n - row);
                    if (total >= l){
                        break;
                    }
                }
                if (row == n){
                    out.println(1); continue;
                }
                else{
                    int k = (int)(r - l + 1);
                    total -= 2 * (n - row);
                    l -= total;
                    int turn = 0;
                    int cur_vertice = row + 1;
                    int cur_row = row;
                    for (int i = 0; i < l - 1; i++){
                        if (turn == 1){
                            cur_vertice++;
                        }
                        turn = turn ^ 1;
                    }
                    for (int time =  0; time < k; time++){
                        if (cur_row == n){
                            out.print(1);
                        }
                        else if (turn == 0){
                            out.print(cur_row + " ");
                        }
                        else{
                            out.print(cur_vertice + " ");
                            cur_vertice++;
                            if (cur_vertice > n){
                                cur_row++;
                                cur_vertice = cur_row + 1;
                            }
                        }
                        turn = turn ^ 1;
                    }
                    out.println();
                }
            }
        }
    }

    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}
