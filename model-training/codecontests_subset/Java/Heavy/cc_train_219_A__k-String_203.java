import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main{
    public static void main(String [] args) throws Exception{
        Main mainClass = new Main();
    }
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    public String next() throws Exception{
        if (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
        
    public int nextInt() throws Exception{
        return Integer.parseInt(next());
    }
        
    public double nextDouble() throws Exception{
        return Double.parseDouble(next());
    }
        
    public long nextLong() throws Exception{
        return Long.parseLong(next());
    }    
    public Main() throws Exception{
        in = new BufferedReader(new InputStreamReader(System.in));
        //in = new BufferedReader(new FileReader("input.txt"));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        //out = new PrintWriter(new FileWriter("output.txt"));
        solve();
        out.close();
    }
    int oo=Integer.MAX_VALUE/2;
    int n;
    int [] arr;
    public void solve() throws Exception{
        int k = nextInt();
        String s = next();
        int m = s.length();
        arr = new int [26];
        for (int i=0;i<m;i++) {
            char c = s.charAt(i);
            int cint = (int)(c) - 97;
            arr[cint]++;
        }
        String ans="";
        boolean solv = true;
        for (int i =0; i< 26; i++){
            if (arr[i]!=0) {
                if (arr[i]%k==0){
                    for (int j = 0;j<arr[i]/k;j++)
                        ans+=(char)(i+97);
                }
                else {
                    solv=false;
                    break;
                }
            }
        }
        if (!solv){
            out.println(-1);
            return;
        } else {
            for (int i = 0;i<k;i++)
                out.print(ans);
        }
    }
}




