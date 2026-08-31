import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;

    static final int Mod=1000000007;

    void solve() throws IOException {
        int n=nextInt();
        int m=nextInt();
        int weight[]=new int[n];
        for (int i = 0; i < n; i++) {
            weight[i]=nextInt();
        }
        int res=0;
        List<Integer> stack=new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            int x=nextInt()-1;
            int where=stack.indexOf(x);
            if(where==-1) {
                where=stack.size();
                stack.add(x);
            }
            for (int j = 0; j < where; j++) {
                res+=weight[stack.get(j)];
            }
            stack.remove(where);
            stack.add(0,x);
        }
        out.println(res);
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}