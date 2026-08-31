import com.sun.jdi.ArrayReference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        String s = fs.next();
        HashMap<String, Integer> ans = new HashMap<>();
        ans.put("A", 0); ans.put("F", 0); ans.put("I", 0);

        for (int i = 0; i<n; i++) {
            String c = s.substring(i,i+1);
            ans.put(c, ans.get(c)+1);
        }
        if (ans.get("I") > 1) {
            System.out.println(0);
        } else if (ans.get("I") == 1) {
            System.out.println(1);
        } else {
            System.out.print(ans.get("A"));
        }



    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

}

