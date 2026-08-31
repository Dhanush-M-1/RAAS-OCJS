import java.util.*;
import java.io.*;
public class A{
    static PrintWriter out;
    static InputReader in;
    public static void main(String args[]){
        out = new PrintWriter(System.out);
        in = new InputReader();
        new A();
        out.flush(); out.close();
    }   
    A(){
        solve();
    }
    void solve(){
        int t = in.nextInt();
        o : while(t-- > 0){
            int n = in.nextInt(), m = in.nextInt();
            int f[][] = new int[2][1001];
            for(int i = 0; i < n; i++)f[0][in.nextInt()]++;
            for(int i = 0; i < m; i++)f[1][in.nextInt()]++;
            for(int i = 0; i < 1001; i++){
                if(f[0][i] != 0 && f[1][i] != 0){
                    out.println("YES\n" + 1 + " " + i);
                    continue o;
                }
            }
            out.println("NO");
        }
    }
    public static class InputReader{
        BufferedReader br;
        StringTokenizer st;
        InputReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){}
            }
            return st.nextToken();
        }
    }
}
        