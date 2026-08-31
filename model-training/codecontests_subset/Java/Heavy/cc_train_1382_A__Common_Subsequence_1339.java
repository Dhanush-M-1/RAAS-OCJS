import java.util.*;
import java.io.*;
public class Main{
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int z = 0; z<t; z++){
            Set<Integer>s = new HashSet<>();
            int n = readInt(), m = readInt();
            for(int i = 0; i<n; i++){
                s.add(readInt());
            }
            int ans = -1;
            for(int i = 0; i<m; i++){
                int a = readInt();
                if(s.contains(a)){
                    ans = a;
                }
            }
            if(ans==-1)System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.println(1+" "+ans);
            }
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(input.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readChar () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return input.readLine().trim();
    }
}
