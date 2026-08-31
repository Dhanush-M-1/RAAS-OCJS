import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static Main.MyScanner sc = new Main.MyScanner();
    static PrintWriter out = new PrintWriter(System.out);
    // static PrintStream out = System.out;

    public static void main(String[] args) {

        int n = sc.nextInt(),m = sc.nextInt() ;
        int w[] = new int[n];
        int days[] = new int[m];
        for(int i = 0 ; i < n ; i++)
            w[i] = sc.nextInt();
        for(int i = 0 ; i < m ; i++)
            days[i] = sc.nextInt()-1;
        boolean dp[] = new boolean[n];
        int seq[] = new int[n],pos = 0;
        for(int i = 0 ; i < m && pos < n ; i++)
            if(!dp[days[i]]){
                dp[days[i]] = true;
                seq[pos++] = days[i];
            }
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        for(int i = n-1 ; i >= 0 ; i--)
            s.push(seq[i]);
        for(int i = 0 ; i < m ; i++){
            Stack<Integer> temp = new Stack<Integer>();
            while(true){
                int now = s.pop();
                if(now == days[i])
                    break;
                ans += w[now];
                temp.push(now);
            }
            while(!temp.isEmpty())
                s.push(temp.pop());
            s.push(days[i]);
        }
        out.print(ans);
        
        out.close();
    }

    static private class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public int mod(long x) {
            // TODO Auto-generated method stub
            return (int) x % 1000000007;
        }

        public int mod(int x) {
            return x % 1000000007;
        }

        boolean hasNext() {
            if (st.hasMoreElements())
                return true;
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.hasMoreTokens();
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
