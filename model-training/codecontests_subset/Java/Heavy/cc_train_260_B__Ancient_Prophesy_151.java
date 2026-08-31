import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    
    static void solve() throws Exception {
        String s = next();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>(100000);
        int k = "13-12-2013".length();
        int max = Integer.MIN_VALUE;    
        String maxStr = "";
        for(int i = 0; i + k <= s.length(); i++){
            String sub = s.substring(i, i + k);
            if(check(sub)){
                if(ht.containsKey(sub)){
                    int cnt = ht.get(sub);
                    ht.remove(sub);
                    ht.put(sub, cnt + 1);
                }else{
                    ht.put(sub, 1);
                }
                int local = ht.get(sub);
                if(local > max){
                    max = local;
                    maxStr = sub;
                }
            }
        }
        out.println(maxStr);
    }

    static int[] dayInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30 ,31, 30, 31};
    
    private static boolean check(String sub) {
        String[] s = sub.split("-");
        if(s.length != 3){
            return false;
        }
        if(s[0].length() != 2 || s[1].length() != 2 || s[2].length() != 4){
            return false;
        }
        int day = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int year = Integer.parseInt(s[2]);
        if(!(year >= 2013 && year <= 2015)){
            return false;
        }
        if(!(month >= 1 && month <= 12)){
            return false;
        }
        if(!(day >= 1 && day <= dayInMonth[month - 1])){
            return false;
        }
        return true;
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new PrintStream(System.out));
            solve();
            out.close();
            br.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
