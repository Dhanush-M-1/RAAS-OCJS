import java.io.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

public class codeforces implements Runnable {

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new codeforces()).run();
    }

    public void run() { /*
                         * try { // br = new BufferedReader(new
                         * FileReader("input.txt")); pw = new
                         * PrintWriter("output.txt"); } catch
                         * (FileNotFoundException e) { e.printStackTrace(); }
                         */
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        solver();
        pw.close();

    }

    private void nline() {
        try {
            if (!stk.hasMoreTokens())
                stk = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("KaVaBUnGO!!!", e);
        }
    }

    private String nstr() {
        while (!stk.hasMoreTokens())
            nline();
        return stk.nextToken();
    }

    private int ni() {
        return Integer.valueOf(nstr());
    }

    private long nl() {
        return Long.valueOf(nstr());
    }

    private double nd() {
        return Double.valueOf(nstr());
    }

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    private void solver() {
        int n = ni();
        String s = nstr();
        int a = 0, f = 0, in =0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)=='A')a++;
            if (s.charAt(i)=='I')in++;
            if(s.charAt(i)=='F')f++;
        }
        int ans =0;
        if (in==1) {
            ans++;
        }else if (in==0){
            ans += a;
        }
        System.out.println(ans);
    }

    private BigInteger nbi() {
        return new BigInteger(nstr());
    }

    void exit() {
        System.exit(0);
    }

}