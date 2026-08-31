

import java.io.*;
import java.util.*;

public class D {
    String filename = null;
    void solve(){
        int n =readInt();
        int m = readInt();

        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = readInt() - 1;
        }

        Set<Integer>[] g = new Set[n];
        for(int i = 0;i<n;i++){
            g[i] = new HashSet<>();
        }

        for(int i = 0;i<m;i++){
            int from = readInt() - 1;
            int to = readInt() - 1;
            g[from].add(to);
        }

        Set<Integer> set = new HashSet<>();
        set.add(a[n - 1]);
        for(int i = n - 2;i>=0;i--){
            boolean good = true;
            int q = a[i];
            for(int j : set){
                if(!g[q].contains(j)){
                    good = false;
                    break;
                }
            }
            if(!good) set.add(q);
        }
        out.print(n - set.size());
    }


    public static void main(String[] args) {
        new D().run();
    }
    private void run() {
        try {
            init();
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private BufferedReader in;
    private StringTokenizer tok = new StringTokenizer("");

    private PrintWriter out;

    private void init() {
        if (filename == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            return;
        }

        try {
            in = new BufferedReader(new FileReader(new File(filename)));
            out = new PrintWriter(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readString() {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }

        return tok.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(readString());
    }

    private long readLong() {
        return Long.parseLong(readString());
    }


}