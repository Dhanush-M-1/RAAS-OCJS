import java.io.*;
import java.util.*;

public class Main{
    private void solve(){
        int n = nextInt();
        char[] c = next().toCharArray();
        int eight = 0;
        int kol = c.length;
        for (int i = 0; i < kol; i++)
            if (c[i]=='8')
                eight++;
        kol /=11;
        if (kol <= eight) {
            out.print(kol);
        }else
            out.print(eight);
    }

    public static void main(String[] args) {
        new Main().run();
    }
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    private void run(){
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
//            br = new BufferedReader(new FileReader("Input.txt"));
//            out = new PrintWriter(new FileWriter("Output.txt"));
            solve();
            br.close();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private long nextLong(){
        return Long.parseLong(next());
    }
    private int nextInt(){
        return Integer.parseInt(next());
    }

    private String next() {
        while(st==null || !st.hasMoreTokens()){
            try{
                st = new StringTokenizer(br.readLine());
            }catch(IOException e){
                e.printStackTrace();
                return "END";
            }
        }
        return st.nextToken();
    }
}
