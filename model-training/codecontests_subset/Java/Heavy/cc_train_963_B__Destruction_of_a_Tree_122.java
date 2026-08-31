import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Struct;

public class Main {

    public static void main(String[] args) {
        try {
            InputStream inputStream = System.in;
            InputReader in = new InputReader(inputStream);
            OutputStream outputStream = System.out;
            PrintWriter out = new PrintWriter(outputStream);
            // FileInputStream fin = new FileInputStream(new File("src/testdata.in"));
            // InputReader in = new InputReader(fin);
            // FileOutputStream fout = new FileOutputStream(new File("src/testData.out"));
            // PrintWriter out = new PrintWriter(fout);
            Solver solver = new Solver();
            solver.solve(in, out);
            out.close();
            // fin.close();
            // fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    static class Solver
    {

        public ArrayList<Integer> Ans;

        public void delete (int[] degree, int[] flag, int root, ArrayList<ArrayList<Integer>> list, int parent) {
            if (flag[root] == 1) return;
            flag[root] = 1;
            Ans.add(root);
            int sze = list.get(root).size();
            for (int i = 0; i < sze; ++i) {
                int nextroot = list.get(root).get(i);
                if (nextroot != parent) {
                    delete(degree, flag, nextroot, list, root);
                }
            }
        }

        public int dfs (int[] degree, int[] flag, int root, ArrayList<ArrayList<Integer>> list, int parent) {
            int ret = 0;
            int sze = list.get(root).size();
            degree[root] = 1;
            if (parent == -1) degree[root] = 0;
            if (sze != 0) {
                for (int i = 0; i < sze; ++i) {
                    int nextroot = list.get(root).get(i);
                    if (nextroot != parent) {
                        dfs(degree, flag, nextroot, list, root);
                        if (flag[nextroot] == 0) degree[root] += 1;
                    }
                }
            }
            if (degree[root] % 2 == 0) {
                delete(degree, flag, root, list, parent);
            }
            return ret;
        }

        public void solve (InputReader cin, PrintWriter cout)
        {
            try {
                int n = cin.nextInt();
                if (n % 2 == 0) {
                    cout.println("NO");
                    return;
                }
                int[] flag = new int[n + 1];
                int[] degree = new int[n + 1];
                int root = 1;
                ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                for (int i = 0; i < n + 1; ++i) {
                    list.add(new ArrayList<Integer>());
                }
                for (int i = 1; i < n + 1; ++i) {
                    int tmp = cin.nextInt();
                    if (tmp != 0) {
                        list.get(i).add(tmp);
                        list.get(tmp).add(i);
                    } else {
                        root = i;
                    }
                }
                Arrays.fill(flag, 0);
                Arrays.fill(degree, 0);
                Ans = new ArrayList<Integer>();
                dfs(degree, flag, root, list, -1);
                cout.println("YES");
                for (int i = 0; i < Ans.size(); ++i) {
                    cout.println(Ans.get(i));
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                return;
            } catch (Exception e) {
                return;
            }

        }
    }

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong () {
            return Long.parseLong(next());
        }

        public double nextDouble () {
            return Double.parseDouble(next());
        }

    }

}