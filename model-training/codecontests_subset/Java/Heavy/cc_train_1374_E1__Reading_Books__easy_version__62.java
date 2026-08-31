import java.io.*;
import java.util.*;

public class r653p5 {
    private static PrintWriter pw = new PrintWriter(System.out);
    private static InputReader sc = new InputReader();
    private static final int a = 0, b = 1, ab = 2;

    static class InputReader{
        private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer tk;

        private void next()throws IOException{
            if(tk == null || !tk.hasMoreTokens())   
                tk = new StringTokenizer(r.readLine());
        }

        private int nextInt()throws IOException{
            next();
            return Integer.parseInt(tk.nextToken());
        }
    }

    public static void main(String args[])throws IOException{        
        solve();
        pw.flush();
        pw.close();
    }

    private static void solve()throws IOException{
        int n = sc.nextInt(), k = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int size[] = new int[3];
        for(int i=0; i<3; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            int t = sc.nextInt(), ch1 = sc.nextInt(), ch2 = sc.nextInt();

            int q = ch1 * 2 + ch2 - 1;

            if(q < 0)   continue;
            list.get(q).add(t);
            size[q]++;
        }

        for(int i=0; i<3; i++)
            Collections.sort(list.get(i));

        long sum[][] = new long[3][];

        for(int i=0; i<3; i++){
            sum[i] = new long[size[i]+1];

            for(int j=0; j<size[i]; j++)
                sum[i][j+1] = sum[i][j] + list.get(i).get(j);
        }

        long ans = Long.MAX_VALUE;

        for(int q=0; q<=k; q++){
            if(q <= size[ab] && k-q <= Math.min(size[a], size[b])){
                long temp = sum[ab][q] + sum[a][k-q] + sum[b][k-q];
                ans = Math.min(temp, ans);
            }
        }

        ans = (ans == Long.MAX_VALUE) ? -1 : ans;

        pw.println(+ans);
    }
}