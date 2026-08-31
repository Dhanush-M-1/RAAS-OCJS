

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    List<Integer>[] g;
    void solve(){
        int n = readInt();
        g = new List[n];
        for(int i = 0;i<n;i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0;i<n - 1;i++){
            int from = readInt() - 1;
            int to = readInt() - 1;
            g[from].add(to);
            g[to].add(from);
        }

        for(int i = 0;i<n;i++){
            for(int j : g[i]){
                if(g[j].size() == 2){
                    out.print("NO");
                    return;
                }
            }
        }
        out.print("YES");
    }

    public static void main(String[] args) {
        new D().run();
    }

    void run(){
        init();
        solve();
        out.close();
    }

    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok = new StringTokenizer("");

    void init(){
        in = new BufferedReader(new InputStreamReader(System.in));
        out  = new PrintWriter(System.out);
    }

    String readLine(){
        try{
            return in.readLine();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    String readString(){
        while(!tok.hasMoreTokens()){
            String nextLine = readLine();
            if(nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken();
    }

    int readInt(){
        return Integer.parseInt(readString());
    }

    long readLong(){
        return Long.parseLong(readString());
    }

    double readDouble(){
        return Double.parseDouble(readString());
    }
}
