//package a.codeforces.rating;

import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;
public class Main {
  static int n,m;
  List<Integer> g;
    public static void main(String[] args) throws Exception{      
        FastReader in = new FastReader();
        String pass=in.next();
        int n = in.nextInt();
        StringBuilder s = new StringBuilder();
        String [] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(a[i]+a[j]);
            }
        }
        if(s.toString().contains(pass)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
   
    }
   
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
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
}
