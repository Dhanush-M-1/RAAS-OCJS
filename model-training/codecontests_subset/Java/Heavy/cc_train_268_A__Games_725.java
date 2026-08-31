//package javaapplication1;
import java.util.*;
import java.io.*;

public class JavaApplication1 implements Runnable {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");
    final boolean OJ = System.getProperty("ONLINE_JUDGE") != null;
    
    void init() throws FileNotFoundException {
        if (OJ) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("Input.txt"));
            out = new PrintWriter("Output.txt");
        }
    }
    
    @Override
    public void run() {
        try {
            init();
            solve();
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    
    public static void main(String[] args) {
        new Thread(null, new JavaApplication1(), "", (1L << 20) * 256).start();
    }

    String readString() {
        while(!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch(Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return tok.nextToken();
    }
    
    int readInt() {
        return Integer.parseInt(readString());
    }
    
    long readLong() {
        return Long.parseLong(readString());
    }
    
    
////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    void solve() {
        int n = readInt();
        int[] h = new int[n];
        int[] g = new int[n];
        for(int i = 0; i < n; i++) {
            h[i] = readInt();
            g[i] = readInt();
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if (h[i] == g[j]) ans++;
                if (g[i] == h[j]) ans++;
            }
        }
        out.println(ans);
    }
    
}