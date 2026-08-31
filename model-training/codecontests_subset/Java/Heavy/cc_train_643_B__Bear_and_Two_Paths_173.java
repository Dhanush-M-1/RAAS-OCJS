
import java.io.*;
import java.util.*;


public class GFG {
	public static void main (String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt(), k = fr.nextInt();
        int a = fr.nextInt(), b = fr.nextInt(),c = fr.nextInt(), d = fr.nextInt();
        if(k < n+1 || n == 4) {
            System.out.println("-1");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 1;i <= n;i++) {
                if(i != a&&i != b &&i != c&&i!=d) {
                    sb.append(i+" ");
                }
            }
            String first = a+" "+c+" "+sb.toString()+d+" "+b;
            String second = c +" "+a+" "+sb.toString()+b+" "+d;
            System.out.println(first);
            System.out.println(second);
        }
       
    }
}
class FastReader {
 
    BufferedReader bf;
    StringTokenizer st;
 
    public FastReader() {
        bf = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(bf.readLine());
            } catch (Exception e) {
                System.out.println(e);
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
            str = bf.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }
}